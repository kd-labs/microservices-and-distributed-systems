package com.kdlabs.clients.fraud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckResponse {

    private Integer customerId;
    private boolean isFraudster;
}
