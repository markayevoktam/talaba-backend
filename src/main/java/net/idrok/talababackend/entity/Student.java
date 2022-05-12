package net.idrok.talababackend.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ism;
    private String familya;
    private String sharif;
    private String hudud;
    private Long yosh;
    private String ishlashJoyi;
    private String oqishgaKirYil;
    private String oqishTugYil;
    private String info;
    @ManyToOne
    private Fayl rasm;

    public Fayl getRasm() {
        return rasm;
    }

    public void setRasm(Fayl rasm) {
        this.rasm = rasm;
    }

    public Student() {

    }


    public Long getYosh() {
        return yosh;
    }

    public void setYosh(Long yosh) {
        this.yosh = yosh;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHudud() {
        return hudud;
    }

    public void setHudud(String hudud) {
        this.hudud = hudud;
    }



    public String getIshlashJoyi() {
        return ishlashJoyi;
    }

    public void setIshlashJoyi(String ishlashJoyi) {
        this.ishlashJoyi = ishlashJoyi;
    }

    public String getOqishgaKirYil() {
        return oqishgaKirYil;
    }

    public void setOqishgaKirYil(String oqishgaKirYil) {
        this.oqishgaKirYil = oqishgaKirYil;
    }

    public String getOqishTugYil() {
        return oqishTugYil;
    }

    public void setOqishTugYil(String oqishTugYil) {
        this.oqishTugYil = oqishTugYil;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }




}
