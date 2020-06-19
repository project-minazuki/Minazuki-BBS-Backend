package com.minazuki.bbsbackend.user.pojo;

import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("user")
public class User {

    private long id;
    private boolean isAdmin;
    private String username;
    private String password;

    private String nickname;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime lastSignIn;
    private String email;
    private String phoneNumber;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDateTime getLastSignIn() {
        return lastSignIn;
    }
    public void setLastSignIn(LocalDateTime lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
}
