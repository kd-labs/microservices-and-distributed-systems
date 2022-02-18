package com.kdlabs.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "notification")
public interface NotificationClient {
}
