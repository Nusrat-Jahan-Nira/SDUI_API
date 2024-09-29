// package com.example.sdui_api.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.sdui_api.dto.req.LoginReqDto;
// import com.example.sdui_api.dto.res.LoginResDto;
// import com.example.sdui_api.model.UIComponent;
// import com.example.sdui_api.service.UIService;


// @RestController
// public class LoginController {

//   private final UIService uiService = new UIService();

//     @PostMapping("/login")
//     public LoginResDto login(@RequestBody LoginReqDto loginRequest) {
//     // Validate the login credentials
//     if ("admin".equals(loginRequest.getUserId()) && "1234".equals(loginRequest.getPass())) {
//         // Valid credentials, returning a dynamic dashboard
//         List<UIComponent> components = uiService.getDashboardComponents();
//         return new LoginResDto(true, "Login successful", components);
//     } else {
//         // Invalid credentials, return error message and login form
//         List<UIComponent> components = uiService.getLoginFormComponents();
//         return  new LoginResDto(false, "Invalid username or password", components);
//     }
//    }



//     @GetMapping("/ui-components")
//     public List<UIComponent> getLoginComponents() {
//         // Return the initial UI form with username and password fields
//         return uiService.getLoginFormComponents();
//     }
// }

package com.example.sdui_api.controller;


import com.example.sdui_api.dto.req.LoginReqDto;
import com.example.sdui_api.dto.req.RegistrationReqDto;
import com.example.sdui_api.model.FormModel;
import com.example.sdui_api.service.UIService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    private final UIService uiService;

    public LoginController(UIService uiService) {
        this.uiService = uiService;
    }

    @GetMapping("/ui-components")
    public FormModel getUIComponents() {
        // Return the initial UI form with username and password fields
        return uiService.getLoginFormComponents();
    }

    @PostMapping("/login")
    public FormModel login(@RequestBody LoginReqDto loginRequest) {
        // Validate the login credentials
        if (loginRequest.getUsername() == null || loginRequest.getUsername().isEmpty()) {
            return new FormModel("1", "Please enter a user name", null);
        }
        
        if (loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            return new FormModel("1", "Please enter a password", null);
        }
        
        if ("admin".equals(loginRequest.getUsername()) && "1234".equals(loginRequest.getPassword())) {
            // Valid credentials, returning a dynamic dashboard
            return new FormModel("0", "Login successful", null);
        } else {
            // Invalid credentials, return error message
            return new FormModel("1", "Invalid username or password", null);
        }
    }

    @GetMapping("/registration-form")
    public FormModel getRegistrationFormComponents() {
        return uiService.getRegistrationFormComponents();
    }

    @PostMapping("/register")
    public FormModel register(@RequestBody RegistrationReqDto registrationRequest) {
        // // Perform validation for registration
        // if ("admin".equals(registrationRequest.getUserId()) && "1234".equals(registrationRequest.getPass())) {
        //     // Assume registration is successful and proceed to login page
        //     FormModel loginForm = uiService.getLoginFormComponents();
        //     return new LoginResDto("0", "Registration successful, redirecting to login...",loginForm.getComponents());
        // } else {
        //     // Return error if registration fails
        //     return new LoginResDto("1", "Registration failed. Please try again.", null);
        // }

    
        // Here, you might typically check against a database for existing users
        
        //  if(registrationRequest.getUsername().isEmpty()){
        //     return new FormModel("1", "Please enter user name", null);
        // }
        // else if(registrationRequest.getPassword().isEmpty()){
        //     return new FormModel("1", "Please enter password", null);
        // }
        // else if(registrationRequest.getConfirmPassword().isEmpty()){
        //     return new FormModel("1", "Please enter confirm password", null);
        // }
        // else if(registrationRequest.getGender().isEmpty()){
        //     return new FormModel("1", "Please enter gender", null);
        // }
        // else if(!registrationRequest.isAcceptTerms()){
        //     return new FormModel("1", "Please enter terms", null);
        // }
        // else if(!registrationRequest.isSubscribeNewsletter()){
        //     return new FormModel("1", "Please enter subscribe news", null);
        // }

        // else if ("admin".equals(registrationRequest.getUsername()) && "1234".equals(registrationRequest.getPassword())) {

        //     // Valid credentials, returning a dynamic dashboard
        //     FormModel loginForm = uiService.getLoginFormComponents();
        //     return new FormModel("0", "Register successful", loginForm.getComponents());
        // } 
        
        // else {
        //     // Invalid credentials, return error message
        //     return new FormModel("1", "Invalid username or password", null);
        // }

         // Perform validation for registration
    String errorMessage = validateRegistrationRequest(registrationRequest);
    if (errorMessage != null) {
        return new FormModel("1", errorMessage, null);
    }

    // Here, you might typically check against a database for existing users
    if ("admin".equals(registrationRequest.getUsername()) && "1234".equals(registrationRequest.getPassword())) {
        // Valid credentials, returning a dynamic dashboard
        FormModel loginForm = uiService.getLoginFormComponents();
        return new FormModel("0", "Registration successful, redirecting to login...", loginForm.getComponents());
    } else {
        // Invalid credentials, return error message
        return new FormModel("1", "Invalid username or password", null);
    }

    }
    private String validateRegistrationRequest(RegistrationReqDto registrationRequest) {
        if (registrationRequest.getUsername() == null || registrationRequest.getUsername().isEmpty()) {
            return "Please enter a username.";
        }
        if (registrationRequest.getPassword() == null || registrationRequest.getPassword().isEmpty()) {
            return "Please enter a password.";
        }
        if (registrationRequest.getConfirmPassword() == null || registrationRequest.getConfirmPassword().isEmpty()) {
            return "Please enter confirm password.";
        }
        if (!registrationRequest.getPassword().equals(registrationRequest.getConfirmPassword())) {
            return "Passwords do not match.";
        }
        if (registrationRequest.getGender() == null || registrationRequest.getGender().isEmpty()) {
            return "Please enter gender.";
        }
        if (!registrationRequest.isAcceptTerms()) {
            return "You must accept the terms and conditions.";
        }
        if (!registrationRequest.isSubscribeNewsletter()) {
            return "You must subscribe to the newsletter.";
        }
    
        return null; // No errors
    }
    
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "Welcome to your dashboard!";
    }
}
