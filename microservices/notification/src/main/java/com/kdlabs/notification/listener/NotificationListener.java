package com.kdlabs.notification.listener;

import com.kdlabs.clients.notification.dto.NotificationRequest;
import com.kdlabs.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = {"${rabbitmq.queues.notification}"})
    public void consumer(NotificationRequest notificationRequest) {

        log.info("Consumed message : {}", notificationRequest);
        notificationService.send(notificationRequest);

    }
}
