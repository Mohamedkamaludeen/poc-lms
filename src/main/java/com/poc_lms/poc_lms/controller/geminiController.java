package com.poc_lms.poc_lms.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gemini")
public class geminiController {

    private final ChatClient chatClient;

    public geminiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chatPrompt(@RequestParam String message) {
        return chatClient
                .prompt(message)
                .call()
                .content();
    }
}
