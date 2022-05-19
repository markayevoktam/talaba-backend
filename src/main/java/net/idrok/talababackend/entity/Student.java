package net.idrok.talababackend.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")
    @Size(min = 3 , max = 20)
    private String ism;
    @Size(min = 3 , max = 20)
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")
    private String familya;
    @Size(min = 3 , max = 20)
    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")
    private String sharif;
    @Size(min = 3 )
    private String hudud;
    @Min(10)
    private Long yosh;
    @Size(min = 3 )
    private String ishlashJoyi;
    private LocalDate oqishgaKirYil;
    private LocalDate oqishTugYil;
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

    public LocalDate getOqishgaKirYil() {
        return oqishgaKirYil;
    }

    public void setOqishgaKirYil(LocalDate oqishgaKirYil) {
        this.oqishgaKirYil = oqishgaKirYil;
    }

    public LocalDate getOqishTugYil() {
        return oqishTugYil;
    }

    public void setOqishTugYil(LocalDate oqishTugYil) {
        this.oqishTugYil = oqishTugYil;
    }

    public String getIshlashJoyi() {
        return ishlashJoyi;
    }

    public void setIshlashJoyi(String ishlashJoyi) {
        this.ishlashJoyi = ishlashJoyi;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }




}
