package com.kdlabs.fraud.service;

import com.kdlabs.fraud.entity.FraudCheckHistory;
import com.kdlabs.fraud.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudster(Integer customerId) {

                FraudCheckHistory newCheckHistory = FraudCheckHistory.builder().
                        customerId(customerId).
                        isFraudster(false).
                        createdAt(LocalDateTime.now()).
                        build();

        fraudCheckHistoryRepository.save(newCheckHistory);

        return false;
    }
}
