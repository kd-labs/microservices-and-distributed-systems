package com.kdlabs.fraud.repository;

import com.kdlabs.fraud.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

    FraudCheckHistory findByCustomerId(Integer customerId);
}
