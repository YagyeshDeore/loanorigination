package com.loanorigination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanStatus {
    private String status;
    private String message;
}
