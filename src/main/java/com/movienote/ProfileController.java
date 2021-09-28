package com.movienote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${app.message}")
    private String welcomeMessage;

    @GetMapping("/profile_status_greeting_message")
    public String getDataBaseConnectionDetails() {
        return welcomeMessage;
    }
}
