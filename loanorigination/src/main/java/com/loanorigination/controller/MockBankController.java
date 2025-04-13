package com.loanorigination.controller;

import com.loanorigination.dto.CreditScoreDTO;
import com.loanorigination.dto.LoanApplicationDTO;
import com.loanorigination.dto.LoanResponse;
import com.loanorigination.dto.LoanStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock-bank")
public class MockBankController {

    // Loan Application Submission
    @PostMapping("/loan/apply")
    public LoanResponse applyLoan(@RequestBody LoanApplicationDTO loanApplicationDTO) {
        // Simulate loan application submission logic
        return new LoanResponse("12345", "Success", "Loan application successfully submitted.");
    }

    // Loan Status Checking
    @GetMapping("/loan/status/{loanId}")
    public LoanStatus getLoanStatus(@PathVariable String loanId) {
        if ("12345".equals(loanId)) {
            return new LoanStatus("Approved", "Your loan has been approved.");
        } else {
            return new LoanStatus("Pending", "Your loan is under review.");
        }
    }

    // Credit Score Retrieval
    @GetMapping("/credit-score/{applicationId}")
    public CreditScoreDTO getCreditScore(@PathVariable String applicationId) {
        // Return mock data for credit score
        return new CreditScoreDTO(750, "CIBIL", "2024-06-01");
    }
}
