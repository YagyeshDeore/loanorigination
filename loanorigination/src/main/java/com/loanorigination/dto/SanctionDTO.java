package com.loanorigination.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SanctionDTO {

    private Long id;
    private Long loanApplicationId;
    private String sanctionedAmount;
    private Date sanctionDate;
    private String agreementStatus;
    private String remarks;
}
