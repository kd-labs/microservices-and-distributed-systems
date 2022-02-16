package com.kdlabs.fraud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudCheckResponse {

    private Integer customerId;
    private boolean isFraudster;
}
