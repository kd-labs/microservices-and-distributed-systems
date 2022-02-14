package com.kdlabs.customer.service;

import com.kdlabs.customer.dto.CustomerRequest;
import com.kdlabs.customer.entity.Customer;
import com.kdlabs.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void registerCustomer(CustomerRequest request) {
        Customer newCustomer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.save(newCustomer);

        // TODO : check if email is valid and not taken

        // TODO : persist customer
    }
}
