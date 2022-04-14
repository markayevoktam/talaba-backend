package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Yutuq;

public class YutuqDTO {
    private Long id;
    private String nom;

    public YutuqDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public YutuqDTO() {
    }

    public YutuqDTO(Yutuq yutuq) {
        this.id=yutuq.getId();
        this.nom=yutuq.getNom();
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
