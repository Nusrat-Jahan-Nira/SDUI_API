// package com.example.sdui_api.service;

// import com.example.sdui_api.model.UIComponent;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class UIService {

//     // Method to get the login form components (username, password, and login button)
//     public List<UIComponent> getLoginFormComponents() {
//         List<UIComponent> components = new ArrayList<>();

//         UIComponent usernameField = new UIComponent();
//         usernameField.setType("text");
//         usernameField.setLabel("Username");
//         usernameField.setPlaceholder("Enter your username");

//         UIComponent passwordField = new UIComponent();
//         passwordField.setType("password");
//         passwordField.setLabel("Password");
//         passwordField.setPlaceholder("Enter your password");

//         UIComponent loginButton = new UIComponent();
//         loginButton.setType("button");
//         loginButton.setLabel("Login");
//         loginButton.setAction("submit");

//         components.add(usernameField);
//         components.add(passwordField);
//         components.add(loginButton);

//         return components;
//     }

//     // Method to get the dashboard components (returned after successful login)
//     public List<UIComponent> getDashboardComponents() {
//         List<UIComponent> components = new ArrayList<>();

//         UIComponent welcomeText = new UIComponent();
//         welcomeText.setType("text");
//         welcomeText.setLabel("Welcome to your dashboard!");

//         UIComponent logoutButton = new UIComponent();
//         logoutButton.setType("button");
//         logoutButton.setLabel("Logout");
//         logoutButton.setAction("logout");

//         components.add(welcomeText);
//         components.add(logoutButton);

//         return components;
//     }
// }

package com.example.sdui_api.service;

import com.example.sdui_api.model.FormModel;
import com.example.sdui_api.model.UIComponent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UIService {

    // Method to get the login form components (username, password, and login button)
    public FormModel getLoginFormComponents() {
        List<UIComponent> components = new ArrayList<>();

        // Create UIComponent for username field
        UIComponent usernameField = createInputComponent("text", "username", "Enter your username");

        // Create UIComponent for password field
        UIComponent passwordField = createInputComponent("password", "password", "Enter your password");

        // Create UIComponent for login button
        UIComponent loginButton = 
        createElevatedButtonComponent("Login", "/login", "POST",
                "Login successful!", "Invalid username or password.");

        // Add components to the list
        components.add(usernameField);
        components.add(passwordField);
        components.add(loginButton);

        return new FormModel("0", "Components fetched successfully.", components);
    }

    List<String> options = Arrays.asList("Option A", "Option B", "Option C");

    public FormModel getRegistrationFormComponents() {
        List<UIComponent> components = new ArrayList<>();

        // Create UIComponent for username field
        UIComponent usernameField = createInputComponent("text", "username", "Enter your username");

        // Create UIComponent for password field
        UIComponent passwordField = createInputComponent("password", "password", "Enter your password");

        // Create UIComponent for confirm password field
        UIComponent confirmPasswordField = createInputComponent("password", "confirmPassword", "Re-enter your password");

        // Create the dropdown component with provided options
        UIComponent dropdown = createDropDownComponent(
                "Select an Option", 
                "", 
                "", 
                "Submission successful!", 
                options,  // Provided options
                "Submission failed.",
                null  // No API call for options
        );

        // Create the dropdown component fetching options from an API
        UIComponent dropdownComponentApiFetch = createDropDownComponent(
                "Select an API Option", 
                "", 
                "GET", 
                "Submission successful!", 
                null,  // No initial options
                "Submission failed.",
                "/optionList" // URL to fetch options
        );


        // Create UIComponent for gender radio buttons
        UIComponent genderField = createRadioComponent("gender", new String[]{"Male", "Female", "Other"});

        // Create UIComponent for terms and conditions checkbox
        UIComponent termsCheckbox = createCheckboxComponent("acceptTerms");

        // Create UIComponent for newsletter subscription switch
        UIComponent newsletterSwitch = createSwitchComponent("subscribeNewsletter");

        // Create UIComponent for text button (Login)
        UIComponent loginTextButton = createTextButtonComponent("Already have an account? Log In", 
        "/login","POST","Login successful!", "Error during login.");

        // Create UIComponent for elevated button (Register) with action details
        UIComponent registerButton = createElevatedButtonComponent("Register", "/register", "POST",
                "Registration successful!", "Error during registration.");

        // Add components to the list
        components.add(usernameField);
        components.add(passwordField);
        components.add(confirmPasswordField);
        components.add(dropdown);
        components.add(dropdownComponentApiFetch);
        components.add(genderField);
        components.add(termsCheckbox);
        components.add(newsletterSwitch);
        components.add(loginTextButton);
        components.add(registerButton);

        return new FormModel("0", "Registration form fetched successfully.", components);
    }

    // Combined helper method to create a text or password input UIComponent
    private UIComponent createInputComponent(String type, String label, String placeholder) {
        UIComponent component = new UIComponent();
        component.setType(type);  // "text" or "password"
        component.setLabel(label);
        component.setPlaceholder(placeholder);
        return component;
    }

    // Helper method to create a radio button UIComponent
    private UIComponent createRadioComponent(String label, String[] options) {
        UIComponent component = new UIComponent();
        component.setType("radio");
        component.setLabel(label);
        // Assuming that options would be handled as a list of values or buttons
        component.setPlaceholder(String.join(", ", options));  // For simplicity
        return component;
    }

    // Helper method to create a checkbox UIComponent
    private UIComponent createCheckboxComponent(String label) {
        UIComponent component = new UIComponent();
        component.setType("checkbox");
        component.setLabel(label);
        return component;
    }

    // Helper method to create a switch UIComponent
    private UIComponent createSwitchComponent(String label) {
        UIComponent component = new UIComponent();
        component.setType("switch");
        component.setLabel(label);
        return component;
    }

    // Helper method to create a text button UIComponent
    private UIComponent createTextButtonComponent(
        String label, String actionUrl, String method, 
        String successMessage, String failureMessage) {
        UIComponent component = new UIComponent();
        component.setType("text_button");
        component.setLabel(label);

        // Set action details for button
        UIComponent.ActionDetails actionDetails = new UIComponent.ActionDetails();
        actionDetails.setUrl(actionUrl);
        actionDetails.setMethod(method);
        actionDetails.setSuccessMessage(successMessage);
        actionDetails.setErrorMessage(failureMessage);
        component.setActionDetails(actionDetails);

        return component;
    }

    // Helper method to create an elevated button UIComponent with ActionDetails
    private UIComponent createElevatedButtonComponent(String label, String actionUrl, String method, String successMessage, String failureMessage) {
        UIComponent component = new UIComponent();
        component.setType("elevated_button");
        component.setLabel(label);

        // Set action details for the button
        UIComponent.ActionDetails actionDetails = new UIComponent.ActionDetails();
        actionDetails.setUrl(actionUrl);
        actionDetails.setMethod(method);
        actionDetails.setSuccessMessage(successMessage);
        actionDetails.setErrorMessage(failureMessage);
        component.setActionDetails(actionDetails);

        return component;
    }

    private UIComponent createDropDownComponent(
        String label, 
        String actionUrl, 
        String method, 
        String successMessage, 
        List<String> options,
        String failureMessage,
        String optionsFetchUrl) {

    UIComponent component = new UIComponent();
    component.setType("dropdown");
    component.setLabel(label);  // Use the provided label
    component.setPlaceholder("Choose one"); // Default placeholder

    // Check if options are provided; if not, fetch from the API
    if (options != null && !options.isEmpty()) {
        component.setOptions(options);
    } else if (optionsFetchUrl != null && !optionsFetchUrl.isEmpty()) {
        // Fetch options from the API
        List<String> fetchedOptions = fetchOptionsFromApi(optionsFetchUrl);
        component.setOptions(fetchedOptions);
    } else {
        component.setOptions(Arrays.asList("No options available")); // Default message
    }

    // Set action details for the dropdown component
    UIComponent.ActionDetails actionDetails = new UIComponent.ActionDetails();
    actionDetails.setUrl(optionsFetchUrl);
    actionDetails.setMethod(method);
    actionDetails.setSuccessMessage(successMessage);
    actionDetails.setErrorMessage(failureMessage);
    component.setActionDetails(actionDetails);

    return component;
}

// Mock method for fetching options from API
private List<String> fetchOptionsFromApi(String optionsFetchUrl) {
    // In a real application, this would involve an HTTP request to the provided URL.
    // For now, we'll return some mock data.
    return Arrays.asList("Fetched Option 1", "Fetched Option 2", "Fetched Option 3");
}

//     // Helper method to create a text input UIComponent
//     private UIComponent createTextComponent(String label, String placeholder) {
//         UIComponent component = new UIComponent();
//         component.setType("text");
//         component.setLabel(label);
//         component.setPlaceholder(placeholder);
//         return component;
//     }

//     // Helper method to create a password input UIComponent
//     private UIComponent createPasswordComponent(String label, String placeholder) {
//         UIComponent component = new UIComponent();
//         component.setType("text");
//         component.setLabel(label);
//         component.setPlaceholder(placeholder);
//         return component;
//     }

//     // Helper method to create a button UIComponent with action details
//     private UIComponent createButtonComponent(String label, String url, String method,
//                                               String successMessage, String errorMessage) {
//         UIComponent button = new UIComponent();
//         button.setType("button");
//         button.setLabel(label);

//         // Set up action details for the button
//         UIComponent.ActionDetails actionDetails = new UIComponent.ActionDetails();
//         actionDetails.setUrl(url); // API endpoint for login
//         actionDetails.setMethod(method); // HTTP method
//         actionDetails.setSuccessMessage(successMessage); // Success message
//         actionDetails.setErrorMessage(errorMessage); // Error message
//         button.setActionDetails(actionDetails);

//         return button;
//     }


}
