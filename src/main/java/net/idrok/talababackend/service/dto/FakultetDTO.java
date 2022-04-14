package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Fakultet;

public class FakultetDTO {
    private Long id;
    private String nom;

    public FakultetDTO(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public FakultetDTO() {
    }

    public FakultetDTO(Fakultet fakultet) {
        this.id=fakultet.getId();
        this.nom=fakultet.getNom();
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
