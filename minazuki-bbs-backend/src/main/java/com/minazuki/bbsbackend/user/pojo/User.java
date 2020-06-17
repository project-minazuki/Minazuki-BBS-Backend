package com.minazuki.bbsbackend.user.pojo;

import org.springframework.stereotype.Component;

@Component("user")
public class User {

    private Long id;

    private int role;

    private String userName;

    private String password;

    public String generateJWT() {
        return null;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
