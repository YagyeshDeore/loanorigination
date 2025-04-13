package com.loanorigination.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreditScoreDTO {

    private Long id;
    private Long leadId;
    private int score;
    private String provider;
    private Date checkedAt;

    // Constructor for mock data creation
    public CreditScoreDTO(int score, String provider, String checkedAt) {
        this.score = score;
        this.provider = provider;
        this.checkedAt = java.sql.Date.valueOf(checkedAt); // Convert string to Date
    }
}
