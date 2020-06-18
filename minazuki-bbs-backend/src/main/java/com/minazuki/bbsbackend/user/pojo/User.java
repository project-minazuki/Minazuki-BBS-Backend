package com.minazuki.bbsbackend.user.pojo;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component("user")
public class User {

    private Long id;
    private boolean isAdmin;
    private String userName;
    private String password;

    private String nickName;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime lastSignIn;
    private String email;
    private String phoneNumber;
    private int adminCategoryId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean admin) {
        isAdmin = admin;
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
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
    public int getAdminCategoryId() {
        return adminCategoryId;
    }
    public void setAdminCategoryId(int adminCategoryId) {
        this.adminCategoryId = adminCategoryId;
    }
}
