package com.kdlabs.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {
                "com.kdlabs.customer",
                "com.kdlabs.amqp"
        }
)
@EnableEurekaClient
public class CustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);

    }

}
