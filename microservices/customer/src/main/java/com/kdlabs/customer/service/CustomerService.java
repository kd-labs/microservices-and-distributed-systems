package com.kdlabs.customer.service;

import com.kdlabs.amqp.RabbitMQMessageProducer;
import com.kdlabs.clients.fraud.FraudClient;
import com.kdlabs.clients.fraud.dto.FraudCheckResponse;
import com.kdlabs.clients.notification.NotificationClient;
import com.kdlabs.clients.notification.dto.NotificationRequest;
import com.kdlabs.customer.dto.CustomerRequest;
import com.kdlabs.customer.entity.Customer;
import com.kdlabs.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
@Getter
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRequest request) {
        Customer newCustomer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // TODO : persist customer
        customerRepository.saveAndFlush(newCustomer);

        log.info("Sending request to fraud microservice for customer id {}", newCustomer.getId());

        // TODO : check if email is valid and not taken

//        Before Feign
//        FraudCheckResponse response = restTemplate.getForObject(
//                "http://fraud/api/v1/checkfraud/{customerId}",
//                FraudCheckResponse.class,
//                newCustomer.getId());

//        After Feign
        FraudCheckResponse response = fraudClient.isFraudster(newCustomer.getId());

        if(response.isFraudster()) {
            throw new IllegalStateException(String.format("Email %s is already taken", newCustomer.getEmail()));
        }

        // TODO: send notification
        NotificationRequest notificationRequest = new NotificationRequest(
                newCustomer.getId(),
                String.format("%s %s", newCustomer.getFirstName(), newCustomer.getLastName()),
                newCustomer.getEmail(),
                "You have been registered in the system");
//        notificationClient.sendNotification(notificationRequest);

        rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }
}
