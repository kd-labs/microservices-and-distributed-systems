package com.kdlabs.notification.controller;

import com.kdlabs.clients.notification.dto.NotificationRequest;
import com.kdlabs.notification.entity.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
public class NotificationController {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notification) {

    }
}
