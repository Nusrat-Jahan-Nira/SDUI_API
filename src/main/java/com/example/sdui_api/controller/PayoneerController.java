package com.example.sdui_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sdui_api.model.FormModel;
import com.example.sdui_api.service.PayoneerService;


@RestController
public class PayoneerController {

    private final PayoneerService uiService;

    public PayoneerController(PayoneerService uiService) {
        this.uiService = uiService;
    }

    @GetMapping("/payoneer-ui-components")
    public FormModel getPayoneerUIComponents() {
        // Return the initial UI form with username and password fields
        return uiService.getPayoneerPaymentV2Components();
    }

}
