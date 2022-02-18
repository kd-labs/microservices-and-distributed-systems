package com.kdlabs.notification.service;

import com.kdlabs.clients.notification.dto.NotificationRequest;
import com.kdlabs.notification.entity.Notification;
import com.kdlabs.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest request) {
       notificationRepository.saveAndFlush(
               Notification.builder()
                       .customerId(request.getCustomerId())
                       .customerName(request.getCustomerName())
                       .customerEmail(request.getCustomerEmail())
                       .createdAt(LocalDateTime.now())
                       .sender("KD")
                       .message(request.getMessage())
                       .build()
       );
    }
}
