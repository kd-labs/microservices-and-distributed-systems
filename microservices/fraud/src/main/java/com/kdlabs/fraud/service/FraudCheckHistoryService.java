package com.kdlabs.fraud.service;

import com.kdlabs.fraud.entity.FraudCheckHistory;
import com.kdlabs.fraud.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class FraudCheckHistoryService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    private final Environment environment;

    public boolean isFraudster(Integer customerId) {

        log.info("Request being processed at server running on port : {}", environment.getProperty("server.port"));

                FraudCheckHistory newCheckHistory = FraudCheckHistory.builder().
                        customerId(customerId).
                        isFraudster(false).
                        createdAt(LocalDateTime.now()).
                        build();

        fraudCheckHistoryRepository.save(newCheckHistory);

        return false;
    }
}
