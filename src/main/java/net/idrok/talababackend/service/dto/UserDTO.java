package net.idrok.talababackend.service.dto;


import net.idrok.talababackend.entity.User;

public class UserDTO {
    private Long id;
    private String ism;
    private String familiya;
    private String login;
    private String parol;
    public UserDTO(){}


    
    public UserDTO(Long id, String ism, String familiya, String login, String parol) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.login = login;
        this.parol = parol;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.ism = user.getIsm();
        this.familiya = user.getFamiliya();
        this.login = user.getLogin();
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
    public String getFamiliya() {
        return familiya;
    }
    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getParol() {
        return parol;
    }
    public void setParol(String parol) {
        this.parol = parol;
    }

    


}
