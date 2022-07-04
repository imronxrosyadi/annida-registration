package com.annida.registration.model.dto;

public class AdditionalInfoDto {

    private String userId;
    private String username;
    private boolean admin;

    public AdditionalInfoDto(String userId, String username, boolean admin) {
        this.userId = userId;
        this.username = username;
        this.admin = admin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
