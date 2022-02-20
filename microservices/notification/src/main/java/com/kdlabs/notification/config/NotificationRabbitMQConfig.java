package com.kdlabs.notification.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NotificationRabbitMQConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(getInternalExchange());
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(getNotificationQueue());
    }

    @Bean
    public Binding internalExchangeToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(topicExchange())
                .with(getInternalNotificationRoutingKey());
    }
}
