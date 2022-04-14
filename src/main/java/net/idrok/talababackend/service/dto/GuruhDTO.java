package net.idrok.talababackend.service.dto;

import net.idrok.talababackend.entity.Guruh;
import net.idrok.talababackend.entity.Yunalish;

public class GuruhDTO {
    private Long id;
    private String nom;
    private Yunalish yunalish;

    
    public GuruhDTO() {
    }

    public GuruhDTO(Long id, String nom, Yunalish yunalish) {
        this.id = id;
        this.nom = nom;
        this.yunalish = yunalish;
    }
    public GuruhDTO(Guruh guruh) {
        this.id = guruh.getId();
        this.nom = guruh.getNom();
        this.yunalish = guruh.getYunalish();
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
