package com.kdlabs.customer.service;

import com.kdlabs.customer.dto.CustomerRequest;
import com.kdlabs.customer.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void registerCustomer(CustomerRequest request) {
        Customer newCustomer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // TODO : check if email is valid and not taken

        // TODO : persist customer
    }
}
