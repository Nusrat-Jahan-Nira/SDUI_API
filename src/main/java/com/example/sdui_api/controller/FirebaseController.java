package com.example.sdui_api.controller;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sdui_api.service.FirebaseService;
import java.util.List;

@RestController
public class FirebaseController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/write/{node}")
    public String writeData(@PathVariable String node, @RequestBody Object data) {
        firebaseService.writeData(node, data);
        return "Data written to Firebase successfully!";
    }

    @GetMapping("/read/{node}")
    public CompletableFuture<List<Object>> readData(@PathVariable String node) {
        return firebaseService.readData(node);
    }

    // @GetMapping("/read/{node}")
    // public CompletableFuture<Map<String, Object>> readData(@PathVariable String node) {
    //     return firebaseService.readData(node);  // Return the data as a response
    // }
    
    // @GetMapping("/read/{node}")
    // public String readData(@PathVariable String node) {
    //     firebaseService.readData(node);
    //     return "Data read from Firebase!";
    // }
}

