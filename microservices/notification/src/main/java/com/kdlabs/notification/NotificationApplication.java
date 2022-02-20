package com.kdlabs.notification;

import com.kdlabs.amqp.RabbitMQMessageProducer;
import com.kdlabs.notification.config.NotificationRabbitMQConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.autoconfig.instrument.messaging.SleuthMessagingProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.kdlabs.notification",
                "com.kdlabs.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationRabbitMQConfig config) {
//        return args -> {
//            producer.publish("foo", config.getInternalExchange(), config.getInternalNotificationRoutingKey());
//        };
//    }
}
