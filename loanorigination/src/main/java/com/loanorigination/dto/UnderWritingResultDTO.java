package com.loanorigination.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UnderWritingResultDTO {

    private Long id;
    private Long loanApplicationId;
    private boolean approved;
    private String reasoning;
    private Date createdAt;
    private Date updatedAt;
}
