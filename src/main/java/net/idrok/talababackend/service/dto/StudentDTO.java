package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Student;

public class StudentDTO {
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



    public StudentDTO() {

    }

    public StudentDTO(Long id, String ism, String familya, String sharif, String hudud, Long yosh, String ishlashJoyi, String oqishgaKirYil, String oqishTugYil, String info) {
        this.id = id;
        this.ism = ism;
        this.familya = familya;
        this.sharif = sharif;
        this.hudud = hudud;
        this.yosh = yosh;
        this.ishlashJoyi = ishlashJoyi;
        this.oqishgaKirYil = oqishgaKirYil;
        this.oqishTugYil = oqishTugYil;
        this.info = info;
    }

    public StudentDTO(Student student) {
        this.id=student.getId();
        this.ism=student.getIsm();
        this.familya=student.getFamilya();
        this.sharif=student.getSharif();
        this.hudud=student.getHudud();
        this.yosh=student.getYosh();
        this.ishlashJoyi=student.getIshlashJoyi();
        this.oqishgaKirYil=student.getOqishgaKirYil();
        this.oqishTugYil=student.getOqishTugYil();
        this.info=student.getInfo();






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

    public Long getYosh() {
        return yosh;
    }

    public void setYosh(Long yosh) {
        this.yosh = yosh;
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
