package com.max.maxChat.controller;

import com.max.maxChat.entity.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@AllArgsConstructor
public class ChatController {

    // ---------------- Public Messages ----------------
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public ChatMessage sendPublic(@Payload ChatMessage message) {
        message.setTime(new Date());

        // If it's a new user join, mark status as JOIN
        if (message.getStatus() == null) {
            message.setStatus("MESSAGE");
        }

        return message;
    }
}
