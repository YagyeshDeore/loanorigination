package com.loanorigination.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanApplicationDTO {
    private Long id;
    private String applicantName;
    private String loanType;
    private Double amount;
    private String status;
}
