package com.max.maxChat.entity;

import lombok.Data;
import java.util.Date;

@Data
public class ChatMessage {
    private String senderName;
    private String message;
    private String status; // "JOIN" or "MESSAGE"
    private Date time;
}
