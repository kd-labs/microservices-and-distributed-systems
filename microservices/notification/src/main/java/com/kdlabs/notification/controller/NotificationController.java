package com.kdlabs.notification.controller;

import com.kdlabs.clients.notification.dto.NotificationRequest;
import com.kdlabs.notification.entity.Notification;
import com.kdlabs.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    private final Environment env;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notification) {
        log.info("Sending notification : {}, server:port = {}", notification, env.getProperty("server.port"));
        notificationService.send(notification);
    }
}
