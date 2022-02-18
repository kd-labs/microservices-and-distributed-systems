package com.kdlabs.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @SequenceGenerator(
            name="notification_seq_gen",
            sequenceName = "notification_seq_gen"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_seq_gen"
    )
    private Integer id;
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String sender;
    private String message;
    private LocalDateTime createdAt;
}
