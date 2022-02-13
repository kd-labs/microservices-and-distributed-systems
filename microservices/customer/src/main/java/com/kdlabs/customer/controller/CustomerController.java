package com.kdlabs.customer.controller;

import com.kdlabs.customer.dto.CustomerRequest;
import com.kdlabs.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest request) {

        log.info("New customer {}", request);
        customerService.registerCustomer(request);
    }
}
