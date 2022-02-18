package com.kdlabs.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {

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
}
