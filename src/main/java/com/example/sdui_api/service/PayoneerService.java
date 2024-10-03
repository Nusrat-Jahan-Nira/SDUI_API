package com.example.sdui_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sdui_api.model.FormModel;
import com.example.sdui_api.model.UIComponent;

@Service
public class PayoneerService {

     public FormModel getPayoneerPaymentV2Components() {
        // Create the components list
        List<UIComponent> components = new ArrayList<>();

         // Add the card component containing multiple labels
        components.add(createCardComponent());
        // Add components to the list (Example Data)
        // components.add(createLabelComponent("Shadhin Card Number", "123456789"));
        // components.add(createLabelComponent("Payoneer Account ID", "987654321"));
        // components.add(createLabelComponent("Payoneer A/C. Balance", "500.00 BDT"));
        components.add(createTextFieldComponent("USD Amount", "", "USD Amount ($)"));
        components.add(createTextFieldComponent("Remarks", "", "Remarks"));
        components.add(createCheckboxComponent("I agree to the Terms & Conditions", "false"));
        components.add(createButtonComponent("Proceed"));
 
         return new FormModel("0", "Components fetched successfully.", components);
    }

    private UIComponent createCardComponent() {
        UIComponent cardComponent = new UIComponent();
        cardComponent.setType("Card");
        cardComponent.setLabel("Card");
    
        // Add child components inside the card
        List<UIComponent> children = new ArrayList<>();
        children.add(createLabelComponent("Shadhin Card Number", "123456789"));
        children.add(createLabelComponent("Payoneer Account ID", "987654321"));
        children.add(createLabelComponent("Payoneer A/C. Balance", "500.00 BDT"));
    
        cardComponent.setChildren(children);
        return cardComponent;
    }

    private UIComponent createLabelComponent(String label, String value) {
        UIComponent component = new UIComponent();
        component.setType("Label");
        component.setLabel(label);
        component.setValue(value);
        component.setPlaceholder(null);
        component.setOptions(null);
        component.setActionDetails(null);
        return component;
    }

    private UIComponent createTextFieldComponent(String label, String value, String placeholder) {
        UIComponent component = new UIComponent();
        component.setType("TextField");
        component.setLabel(label);
        component.setValue(value);
        component.setPlaceholder(placeholder);
        component.setOptions(null);
        component.setActionDetails(null);
        return component;
    }

    private UIComponent createCheckboxComponent(String label, String value) {
        UIComponent component = new UIComponent();
        component.setType("Checkbox");
        component.setLabel(label);
        component.setValue(value);
        component.setPlaceholder(null);
        component.setOptions(null);
        component.setActionDetails(null);
        return component;
    }

    private UIComponent createButtonComponent(String label) {
        UIComponent component = new UIComponent();
        component.setType("Button");
        component.setLabel(label);
        component.setValue(null);
        component.setPlaceholder(null);
        component.setOptions(null);

        UIComponent.ActionDetails actionDetails = new UIComponent.ActionDetails();
        actionDetails.setUrl("/api/submit");
        actionDetails.setMethod("POST");
        actionDetails.setSuccessMessage("Form submitted successfully");
        actionDetails.setErrorMessage("Failed to submit form");

        component.setActionDetails(actionDetails);
        return component;
    }
}