package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Loyiha;

public class LoyihaDTO {
    private Long id;
    private String nom;

    public LoyihaDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public LoyihaDTO() {
    }

    public LoyihaDTO(Loyiha loyiha) {
        this.id=loyiha.getId();
        this.nom=loyiha.getNom();
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
    
    
}
