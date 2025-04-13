package com.loanorigination.controller;

import com.loanorigination.dto.CreditScoreDTO;
import com.loanorigination.dto.LoanApplicationDTO;
import com.loanorigination.dto.LoanResponse;
import com.loanorigination.dto.LoanStatus;
import com.loanorigination.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final BankService bankService;

    public LoanController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/apply")
    public LoanResponse applyForLoan(@RequestBody LoanApplicationDTO loanApplicationDTO) {
        return bankService.submitLoanApplication(loanApplicationDTO);
    }

    @GetMapping("/status/{loanId}")
    public LoanStatus getLoanStatus(@PathVariable String loanId) {
        return bankService.getLoanStatus(loanId);
    }

    @GetMapping("/credit-score/{applicationId}")
    public CreditScoreDTO getCreditScore(@PathVariable String applicationId) {
        return bankService.getCreditScore(applicationId);
    }
}
