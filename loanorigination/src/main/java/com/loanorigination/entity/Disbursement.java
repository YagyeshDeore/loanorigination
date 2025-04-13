package com.loanorigination.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Disbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long loanApplicationId;

    private Double amount;

    private String bankAccountNumber;

    private String ifscCode;

    private String status; // e.g., "PENDING", "COMPLETED"

    private LocalDateTime disbursedAt;
}
