package com.example.sdui_api.model;
import java.util.List;


public class FormModel {
    private String statusCode;
    private String statusMessage;
    private List<UIComponent> components;

    public FormModel(String statusCode, String statusMessage, List<UIComponent> components) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.components = components;
    }

    // Getters
    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public List<UIComponent> getComponents() {
        return components;
    }
}
