package com.loanorigination.service;

import com.loanorigination.dto.CreditScoreDTO;

import java.util.List;

public interface CreditScoreService {

    CreditScoreDTO getCreditScore(Long leadId);
    List<CreditScoreDTO> getAllCreditScores();
    CreditScoreDTO saveCreditScore(CreditScoreDTO creditScoreDTO);
}
