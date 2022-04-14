package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Fakultet;
import net.idrok.talababackend.entity.Yunalish;

public class YunalishDTO {
    private Long id;
    private String nom;
    private Fakultet fakultet;

    
    public YunalishDTO() {
    }

    public YunalishDTO(Long id, String nom, Fakultet fakultet) {
        this.id = id;
        this.nom = nom;
        this.fakultet = fakultet;
    }
    public YunalishDTO(Yunalish yunalish) {
        this.id = yunalish.getId();
        this.nom = yunalish.getNom();
        this.fakultet = yunalish.getFakultet();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Fakultet getFakultet() {
        return fakultet;
    }
    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }
    
    
}
