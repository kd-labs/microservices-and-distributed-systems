package com.kdlabs.customer.controller;

import com.kdlabs.customer.dto.CustomerRequest;
import com.kdlabs.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void registerCustomer(@RequestBody CustomerRequest request) {

        log.info("New customer {}", request);
        customerService.registerCustomer(request);
    }
}
