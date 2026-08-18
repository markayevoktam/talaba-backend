# talaba-backend

Spring Boot 2.6 + PostgreSQL. Frontend: https://github.com/markayevoktam/talaba-front (Cloudflare Pages: https://talaba-frontend.pages.dev)

## Lokal ishga tushirish (Docker)

```bash
docker compose up -d --build   # Postgres + API, http://localhost:8080
```

## Sozlamalar (env)

| O'zgaruvchi | Standart | Izoh |
|---|---|---|
| `SPRING_DATASOURCE_URL` | `jdbc:postgresql://localhost:5432/talaba1` | Neon: `jdbc:postgresql://HOST/DB?sslmode=require` |
| `SPRING_DATASOURCE_USERNAME` | `postgres` | |
| `SPRING_DATASOURCE_PASSWORD` | `123` | |
| `JWT_SECRET` | (dev qiymati) | Production'da albatta o'zgartiring |
| `CORS_ALLOWED_ORIGINS` | `http://localhost:4200,https://talaba-frontend.pages.dev` | vergul bilan |
| `FILES_DIR` | `files` | yuklangan fayllar papkasi |
| `PORT` | `8080` | |

## Render.com'ga deploy

1. https://neon.tech — bepul Postgres yarating, ulanish ma'lumotlarini oling (host, db, user, password).
2. https://render.com → **New → Blueprint** → `talaba-backend` reposini tanlang. `render.yaml` o'qiladi.
3. So'ralgan env'larni kiriting: `SPRING_DATASOURCE_URL` = `jdbc:postgresql://HOST/DB?sslmode=require`, username, password.
4. **Apply** — bir necha daqiqada `https://talaba-backend.onrender.com` ishlaydi. Har `master`ga push avtomatik deploy qiladi.

Eslatma: bepul Render diski vaqtinchalik — yuklangan fayllar (`/app/files`) qayta deploy'da o'chadi.

## Railway'ga deploy

1. https://railway.com → GitHub bilan kiring → **New Project → Deploy from GitHub repo** → `talaba-backend`.
2. Loyihada **+ Create → Database → PostgreSQL** qo'shing.
3. `talaba-backend` servisi → **Variables** → quyidagilarni qo'shing (Postgres'ga havola):
   - `SPRING_DATASOURCE_URL` = `jdbc:postgresql://${{Postgres.PGHOST}}:${{Postgres.PGPORT}}/${{Postgres.PGDATABASE}}`
   - `SPRING_DATASOURCE_USERNAME` = `${{Postgres.PGUSER}}`
   - `SPRING_DATASOURCE_PASSWORD` = `${{Postgres.PGPASSWORD}}`
   - `JWT_SECRET` = uzun tasodifiy satr
   - `CORS_ALLOWED_ORIGINS` = `https://talaba-frontend.pages.dev,http://localhost:4200`
4. **Settings → Networking → Generate Domain** — ochiq URL olinadi (`https://....up.railway.app`).
5. (Ixtiyoriy) **Settings → Volumes** → mount path `/app/files` — yuklangan fayllar saqlanib qolsin.
