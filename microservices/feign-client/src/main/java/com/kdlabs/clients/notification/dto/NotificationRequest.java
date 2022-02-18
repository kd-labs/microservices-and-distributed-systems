package com.kdlabs.clients.notification.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotificationRequest {

    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String message;
}
