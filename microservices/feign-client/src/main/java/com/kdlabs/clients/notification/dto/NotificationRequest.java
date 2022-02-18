package com.kdlabs.clients.notification.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class NotificationRequest {

    private Integer customerId;
    private String customerName;
    private String message;
}
