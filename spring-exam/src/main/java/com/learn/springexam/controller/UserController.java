package com.learn.springexam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @PostMapping("/deactivate")
    public ResponseEntity<Map<String, String>> deactivate() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("deactivateDateTime", "1747198205");

        return ResponseEntity.ok(responseBody); // statusCode = 200
    }
}
