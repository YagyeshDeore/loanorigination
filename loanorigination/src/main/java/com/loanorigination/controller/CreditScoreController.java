package com.loanorigination.controller;

import com.loanorigination.dto.CreditScoreDTO;
import com.loanorigination.service.CreditScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit-scores")
public class CreditScoreController {

    @Autowired
    private CreditScoreService creditScoreService;

    @GetMapping("/{leadId}")
    public CreditScoreDTO getCreditScore(@PathVariable Long leadId) {
        return creditScoreService.getCreditScore(leadId);
    }

    @GetMapping
    public List<CreditScoreDTO> getAllCreditScores() {
        return creditScoreService.getAllCreditScores();
    }

    @PostMapping
    public CreditScoreDTO saveCreditScore(@RequestBody CreditScoreDTO creditScoreDTO) {
        return creditScoreService.saveCreditScore(creditScoreDTO);
    }
}
