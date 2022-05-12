package net.idrok.talababackend.entity;

import javax.persistence.*;

@Entity
public class Talaba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String ism;
    private String familya;
    private String sharif;
    private Long yosh;
    private String hudud;

    @ManyToOne
    private Fayl rasm;


    @ManyToOne
    Loyiha loyiha;
    @ManyToOne
    Guruh guruh;

    public Loyiha getLoyiha() {
        return loyiha;
    }

    public void setLoyiha(Loyiha loyiha) {
        this.loyiha = loyiha;
    }

    @ManyToOne
    Xarakter xarakter;

    private OquvShakl oquvShakl;


    private String info;


    public Talaba() {

    }

    public OquvShakl getOquvShakl() {
        return oquvShakl;
    }

    public void setOquvShakl(OquvShakl oquvShakl) {
        this.oquvShakl = oquvShakl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamilya() {
        return familya;
    }

    public void setFamilya(String familya) {
        this.familya = familya;
    }

    public String getSharif() {
        return sharif;
    }



    public void setSharif(String sharif) {
        this.sharif = sharif;
    }

    public Fayl getRasm() {
        return rasm;
    }

    public void setRasm(Fayl rasm) {
        this.rasm = rasm;
    }



    public String getHudud() {
        return hudud;
    }

    public void setHudud(String hudud) {
        this.hudud = hudud;
    }

    public Long getYosh() {
        return yosh;
    }

    public void setYosh(Long yosh) {
        this.yosh = yosh;
    }

    public Guruh getGuruh() {
        return guruh;
    }

    public void setGuruh(Guruh guruh) {
        this.guruh = guruh;
    }

    public Xarakter getXarakter() {
        return xarakter;
    }

    public void setXarakter(Xarakter xarakter) {
        this.xarakter = xarakter;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
