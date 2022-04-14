package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Xarakter;

public class XarakterDTO {
    private Long id;
    private String nom;

    public XarakterDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public XarakterDTO() {
    }

    public XarakterDTO(Xarakter xarakter) {
        this.id=xarakter.getId();
        this.nom=xarakter.getNom();
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
