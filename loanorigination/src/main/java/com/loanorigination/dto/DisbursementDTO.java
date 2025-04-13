package com.loanorigination.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisbursementDTO {

    private Long id;

    private Long loanApplicationId;

    private Double amount;

    private String bankAccountNumber;

    private String ifscCode;

    private String status;

    private LocalDateTime disbursedAt;
}
