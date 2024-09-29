package com.example.sdui_api.dto.req;

import java.util.Objects;

public class LoginReqDto {
    private String username; // User ID for login
    private String password; // Password for login

    // Default constructor
    public LoginReqDto() {
    }

    // Constructor with parameters
    public LoginReqDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Override toString
    @Override
    public String toString() {
        return "LoginReqDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // Override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginReqDto)) return false;
        LoginReqDto that = (LoginReqDto) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
