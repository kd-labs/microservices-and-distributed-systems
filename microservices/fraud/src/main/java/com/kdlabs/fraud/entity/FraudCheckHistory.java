package com.kdlabs.fraud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(name="fraud_sequence_gen", sequenceName = "fraud_sequence_gen")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_sequence_gen")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
