package com.kdlabs.fraud.controller;

import com.kdlabs.fraud.dto.FraudCheckResponse;
import com.kdlabs.fraud.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/checkfraud")
@AllArgsConstructor
@Slf4j
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {

        log.info("Check if customer id {} is fraud or not", customerId);
        boolean isFraudster = fraudCheckHistoryService.isFraudster(customerId);

        return new FraudCheckResponse(customerId, isFraudster);

    }
}
