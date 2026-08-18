#!/usr/bin/env python3
"""
Demo ma'lumotlar bilan to'ldirish (lokal yoki boshqa server).
Foydalanish:
  python3 scripts/demo_seed.py                      # http://localhost:8080, admin123/admin123
  python3 scripts/demo_seed.py --api https://... --login admin123 --parol ...
Rasmlar: PIL bo'lsa har bir talabaga 300x400 avatar yaratib yuklaydi.
"""
import argparse, io, json, random, sys, urllib.request, urllib.error, uuid

random.seed(42)

ap = argparse.ArgumentParser()
ap.add_argument('--api', default='http://localhost:8080')
ap.add_argument('--login', default='admin123')
ap.add_argument('--parol', default='admin123')
ap.add_argument('--rasmsiz', action='store_true', help="rasm yaratmaslik")
args = ap.parse_args()
API = args.api.rstrip('/')

def req(method, path, data=None, token=None, raw=None, ctype='application/json'):
    url = API + path
    body = raw if raw is not None else (json.dumps(data).encode() if data is not None else None)
    r = urllib.request.Request(url, data=body, method=method)
    if body is not None: r.add_header('Content-Type', ctype)
    if token: r.add_header('Authorization', 'Bearer ' + token)
    try:
        with urllib.request.urlopen(r, timeout=120) as resp:
            t = resp.read().decode()
            return json.loads(t) if t else None
    except urllib.error.HTTPError as e:
        print(f"  XATO {method} {path}: {e.code} {e.read().decode()[:200]}")
        return None

tok = req('POST', '/api/account/auth', {'username': args.login, 'password': args.parol})
if not tok: sys.exit("Login bo'lmadi")
T = tok['token']
print("Login OK")

def mavjud(path):
    """Ro'yxat bo'sh bo'lmasa qayta yaratmaslik uchun"""
    r = req('GET', path + '?page=0&size=200', token=T)
    if isinstance(r, dict): return r.get('content', [])
    return r or []

# ---------- Fakultetlar ----------
FAKULTETLAR = [
    ("Axborot texnologiyalari", "Dasturiy injiniring, kompyuter injiniringi va AI yo'nalishlari"),
    ("Iqtisodiyot va menejment", "Iqtisodiyot, moliya va biznes boshqaruvi"),
    ("Muhandislik", "Energetika, mexanika va qurilish"),
    ("Filologiya", "Tillar, tarjima va jurnalistika"),
]
fak = mavjud('/api/fakultet')
if not fak:
    for nom, info in FAKULTETLAR:
        f = req('POST', '/api/fakultet', {'nom': nom, 'info': info}, T)
        if f: fak.append(f)
print(f"Fakultetlar: {len(fak)}")
fak_by = {f['nom']: f for f in fak}

# ---------- Yo'nalishlar ----------
YUNALISHLAR = [
    ("Dasturiy injiniring", "Axborot texnologiyalari"),
    ("Kompyuter injiniringi", "Axborot texnologiyalari"),
    ("Sun'iy intellekt", "Axborot texnologiyalari"),
    ("Iqtisodiyot", "Iqtisodiyot va menejment"),
    ("Moliya va kredit", "Iqtisodiyot va menejment"),
    ("Elektr energetikasi", "Muhandislik"),
    ("Qurilish muhandisligi", "Muhandislik"),
    ("Ingliz filologiyasi", "Filologiya"),
]
yun = mavjud('/api/yunalish')
if not yun:
    for nom, fnom in YUNALISHLAR:
        f = fak_by.get(fnom) or fak[0]
        y = req('POST', '/api/yunalish', {'nom': nom, 'fakultet': {'id': f['id']}, 'info': f"{fnom} fakulteti"}, T)
        if y: yun.append(y)
print(f"Yo'nalishlar: {len(yun)}")

# ---------- Guruhlar ----------
gur = mavjud('/api/guruh')
if not gur:
    kod = {"Dasturiy injiniring": "DI", "Kompyuter injiniringi": "KI", "Sun'iy intellekt": "SI",
           "Iqtisodiyot": "IQ", "Moliya va kredit": "MK", "Elektr energetikasi": "EE",
           "Qurilish muhandisligi": "QM", "Ingliz filologiyasi": "IF"}
    for y in yun:
        k = kod.get(y['nom'], 'GR')
        for yil in (22, 23):
            g = req('POST', '/api/guruh', {'nom': f"{k}-{yil}-0{random.randint(1,3)}", 'yunalish': {'id': y['id']}, 'info': f"{y['nom']}, 20{yil} yil qabuli"}, T)
            if g: gur.append(g)
print(f"Guruhlar: {len(gur)}")

# ---------- Loyihalar / Yutuqlar / Xarakterlar ----------
LOYIHALAR = [("Talaba portali", "Universitet ichki portali"), ("Aqlli kutubxona", "RFID asosidagi kutubxona tizimi"),
             ("Mobil ilova: Dars jadvali", "Android/iOS"), ("Robototexnika to'garagi", "Arduino loyihalari"),
             ("Startap: EduPay", "Ta'lim to'lovlari xizmati"), ("Ekologik monitoring", "IoT sensorlar tarmog'i")]
YUTUQLAR = [("Respublika olimpiadasi g'olibi", "Fan olimpiadalari"), ("Prezident stipendiati", "Davlat stipendiyasi"),
            ("Xalqaro konferensiya ma'ruzachisi", "Ilmiy maqola"), ("Hackathon g'olibi", "IT tanlovlar"),
            ("Faol talaba", "Jamoat ishlari"), ("Sport ustasi", "Sport yutuqlari")]
XARAKTERLAR = [("Yetakchi", "Tashkilotchilik qobiliyati yuqori"), ("Tadqiqotchi", "Ilmiy izlanishga moyil"),
               ("Ijodkor", "Nostandart fikrlaydi"), ("Jamoaviy", "Jamoada yaxshi ishlaydi"),
               ("Intizomli", "Mas'uliyatli va puxta"), ("Tashabbuskor", "Yangi g'oyalar beradi")]
def oddiy(path, items):
    r = mavjud(path)
    if not r:
        for nom, info in items:
            x = req('POST', path, {'nom': nom, 'info': info}, T)
            if x: r.append(x)
    return r
loy = oddiy('/api/loyiha', LOYIHALAR); print(f"Loyihalar: {len(loy)}")
yut = oddiy('/api/yutuq', YUTUQLAR);   print(f"Yutuqlar: {len(yut)}")
xar = oddiy('/api/xarakter', XARAKTERLAR); print(f"Xarakterlar: {len(xar)}")

# ---------- Rasm ----------
def avatar_png(ism, familya, rang):
    try:
        from PIL import Image, ImageDraw, ImageFont
    except ImportError:
        return None
    im = Image.new('RGB', (300, 400), rang)
    d = ImageDraw.Draw(im)
    # yumaloq bosh va yelka silueti
    d.ellipse((100, 90, 200, 190), fill=(255, 255, 255))
    d.rounded_rectangle((60, 210, 240, 400), radius=60, fill=(255, 255, 255))
    harf = (familya[:1] + ism[:1]).upper()
    try:
        font = ImageFont.truetype("/usr/share/fonts/dejavu-sans-fonts/DejaVuSans-Bold.ttf", 44)
    except Exception:
        try: font = ImageFont.truetype("DejaVuSans-Bold.ttf", 44)
        except Exception: font = ImageFont.load_default()
    d.text((150, 300), harf, fill=rang, font=font, anchor="mm")
    b = io.BytesIO(); im.save(b, 'PNG'); return b.getvalue()

def rasm_yukla(png, nom):
    if not png: return None
    bnd = uuid.uuid4().hex
    body = (f"--{bnd}\r\nContent-Disposition: form-data; name=\"file\"; filename=\"{nom}\"\r\n"
            f"Content-Type: image/png\r\n\r\n").encode() + png + f"\r\n--{bnd}--\r\n".encode()
    return req('POST', '/api/file/upload', raw=body, token=T, ctype=f"multipart/form-data; boundary={bnd}")

RANGLAR = [(42,120,214),(235,104,52),(27,175,122),(237,161,0),(232,123,164),(0,131,0),(74,58,167),(227,73,72)]

# ---------- Talabalar ----------
ISMLAR_E = ["Jasur","Sardor","Bekzod","Aziz","Nodir","Sherzod","Ulug'bek","Javohir","Doston","Bobur","Farrux","Otabek","Shohruh","Temur","Ilhom"]
ISMLAR_A = ["Madina","Nilufar","Zarina","Dilnoza","Sevara","Gulnora","Malika","Kamola","Shahnoza","Nargiza","Feruza","Dildora","Mohira"]
FAMILYA = ["Karimov","Rahimov","Tursunov","Yusupov","Abdullayev","Ergashev","Xolmatov","Saidov","Mirzayev","Qodirov","Nazarov","Toshpo'latov","Sultonov","Umarov","Islomov"]
HUDUD = ["Toshkent sh.","Toshkent vil.","Samarqand","Buxoro","Farg'ona","Andijon","Namangan","Qashqadaryo","Surxondaryo","Xorazm","Navoiy","Jizzax","Sirdaryo","Qoraqalpog'iston"]

tal = mavjud('/api/talaba')
if not tal:
    for i in range(40):
        ayol = random.random() < 0.45
        ism = random.choice(ISMLAR_A if ayol else ISMLAR_E)
        fam = random.choice(FAMILYA) + ("a" if ayol else "")
        ota = random.choice(ISMLAR_E)
        sharif = ota + (" qizi" if ayol else " o'g'li")
        g = random.choice(gur)
        t = {
            'ism': ism, 'familya': fam, 'sharif': sharif,
            'yosh': random.randint(18, 24), 'hudud': random.choice(HUDUD),
            'ball': random.randint(55, 100), 'kurs': str(random.randint(1, 4)),
            'guruh': {'id': g['id']}, 'loyiha': {'id': random.choice(loy)['id']},
            'xarakter': {'id': random.choice(xar)['id']}, 'yutuq': {'id': random.choice(yut)['id']},
            'oquvShakl': random.choice(['GRAND', 'SHARTNOMA', 'SHARTNOMA']),
            'talented': random.random() < 0.25,
            'info': random.choice(["", "Guruh sardori", "Ilmiy to'garak a'zosi", "Volontyor", "Sport jamoasi a'zosi", ""]),
        }
        if not args.rasmsiz:
            f = rasm_yukla(avatar_png(ism, fam, random.choice(RANGLAR)), f"{fam}_{ism}.png")
            if f and f.get('id'): t['rasm'] = {'id': f['id']}
        r = req('POST', '/api/talaba', t, T)
        if r: tal.append(r)
print(f"Talabalar: {len(tal)}")

# ---------- Faxrli talabalar (bitiruvchilar) ----------
ISH = ["EPAM Systems, dasturchi", "Uzum Technologies, backend dasturchi", "Milliy bank, iqtisodchi",
       "UzAuto Motors, muhandis", "TDIU, o'qituvchi", "Payme, mahsulot menejeri", "IT Park rezidenti, asoschi",
       "Toshkent shahar hokimligi, mutaxassis", "Beeline Uzbekistan, tahlilchi", "O'zbekneftgaz, muhandis"]
stu = mavjud('/api/student')
if not stu:
    for i in range(12):
        ayol = random.random() < 0.4
        ism = random.choice(ISMLAR_A if ayol else ISMLAR_E)
        fam = random.choice(FAMILYA) + ("a" if ayol else "")
        kir = random.randint(2014, 2019)
        s = {
            'ism': ism, 'familya': fam, 'sharif': random.choice(ISMLAR_E) + (" qizi" if ayol else " o'g'li"),
            'yosh': random.randint(25, 33), 'hudud': random.choice(HUDUD),
            'ishlashJoyi': random.choice(ISH),
            'oqishgaKirYil': f"{kir}-09-01", 'oqishTugYil': f"{kir+4}-06-30",
            'oquvShakl': random.choice(['GRAND', 'SHARTNOMA']),
            'info': random.choice(["Imtiyozli diplom", "Magistratura bitiruvchisi", "", "Xalqaro sertifikat egasi"]),
        }
        if not args.rasmsiz:
            f = rasm_yukla(avatar_png(ism, fam, random.choice(RANGLAR)), f"{fam}_{ism}.png")
            if f and f.get('id'): s['rasm'] = {'id': f['id']}
        r = req('POST', '/api/student', s, T)
        if r: stu.append(r)
print(f"Bitiruvchilar: {len(stu)}")

# ---------- Foydalanuvchilar ----------
users = req('GET', '/api/user', token=T) or []
if len(users) <= 1:
    for ism, fam, login, rol in [("Dilshod", "Rahmonov", "dilshod01", "ADMIN"), ("Nigora", "Yusupova", "nigora01", "USER"), ("Akmal", "Tursunov", "akmal01", "USER")]:
        req('POST', '/api/user', {'ism': ism, 'familiya': fam, 'login': login, 'parol': 'parol123', 'role': rol}, T)
    users = req('GET', '/api/user', token=T) or []
print(f"Foydalanuvchilar: {len(users)} (demo parol: parol123)")
print("Tayyor.")
