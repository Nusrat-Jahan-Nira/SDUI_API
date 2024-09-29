package com.example.sdui_api.dto.req;

public class RegistrationReqDto {

    private String username; // Changed from userId to username
    private String password; // Changed from pass to password
    private String confirmPassword; // Remains the same
    private String gender; // Remains the same
    private boolean acceptTerms; // Changed from termsAccepted to acceptTerms
    private boolean subscribeNewsletter; // Remains the same

    // Default constructor
    public RegistrationReqDto() {}

    // Parameterized constructor
    public RegistrationReqDto(String username, String password, String confirmPassword, String gender, boolean acceptTerms, boolean subscribeNewsletter) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
        this.acceptTerms = acceptTerms;
        this.subscribeNewsletter = subscribeNewsletter;
    }

    // Getters and Setters

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAcceptTerms() { // Updated to reflect new naming
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) { // Updated to reflect new naming
        this.acceptTerms = acceptTerms;
    }

    public boolean isSubscribeNewsletter() {
        return subscribeNewsletter;
    }

    public void setSubscribeNewsletter(boolean subscribeNewsletter) {
        this.subscribeNewsletter = subscribeNewsletter;
    }

    // Method to validate registration data
    public boolean isValid() {
        // Ensure that the passwords match
        if (!password.equals(confirmPassword)) {
            return false;
        }
        // Ensure that the terms are accepted
        if (!acceptTerms) {
            return false;
        }
        // Check if username, password, and gender are provided
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || gender == null || gender.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegistrationReqDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", gender='" + gender + '\'' +
                ", acceptTerms=" + acceptTerms +
                ", subscribeNewsletter=" + subscribeNewsletter +
                '}';
    }
}
