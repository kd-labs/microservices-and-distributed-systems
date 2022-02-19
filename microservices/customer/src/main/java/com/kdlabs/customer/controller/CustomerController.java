package com.kdlabs.customer.controller;

import com.kdlabs.customer.dto.CustomerRequest;
import com.kdlabs.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableFeignClients(basePackages = "com.kdlabs.clients")
@RequestMapping("api/v1/customers")
@Slf4j
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    private final Environment env;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void registerCustomer(@RequestBody CustomerRequest request) {

        log.info("New customer {}, server.port: {}", request, env.getProperty("server.port"));
        customerService.registerCustomer(request);
    }
}
