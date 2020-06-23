package com.minazuki.bbsbackend.user.pojo;

import lombok.Builder;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Alias("user")
@ToString
@Builder
public class User {

    private Integer id;
    private Boolean isAdmin;
    private String username;
    private String password;

    private String nickname;
    private String signature;
    private Boolean privacyShow;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime lastSignIn;
    private String email;
    private String phoneNumber;

    public User(Integer id, Boolean isAdmin, String username, String password, String nickname, String signature,
                Boolean privacyShow, String avatarUrl, LocalDateTime createdAt, LocalDateTime lastSignIn,
                String email, String phoneNumber) {
        this.id = id;
        this.isAdmin = isAdmin;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.signature = signature;
        this.privacyShow = privacyShow;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.lastSignIn = lastSignIn;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(Boolean admin) {
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
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public Boolean isPrivacyShow() {
        return privacyShow;
    }
    public void setPrivacyShow(Boolean privacyShow) {
        this.privacyShow = privacyShow;
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
