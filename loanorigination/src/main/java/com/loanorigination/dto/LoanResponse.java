package com.loanorigination.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoanResponse {
    private String loanId;
    private String status;
    private String message;

    // Constructors, Getters, Setters
}
