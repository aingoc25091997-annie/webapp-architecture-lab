package com.annie.webapp.dto;

public class LoginResponse {
    private String username;
    private Long userId;

    public LoginResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public LoginResponse(String username, Long userId, String status, String message) {
        this.username = username;
        this.userId = userId;
        this.status = status;
        this.message = message;
    }

    private String status;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
