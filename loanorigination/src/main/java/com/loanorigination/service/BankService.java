
package com.loanorigination.service;

import com.loanorigination.dto.CreditScoreDTO;
import com.loanorigination.dto.LoanApplicationDTO;
import com.loanorigination.dto.LoanResponse;
import com.loanorigination.dto.LoanStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankService {

    private final RestTemplate restTemplate;

    public BankService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Submit Loan Application
    public LoanResponse submitLoanApplication(LoanApplicationDTO loanApplicationDTO) {
        String url = "http://localhost:8080/mock-bank/loan/apply";
        return restTemplate.postForObject(url, loanApplicationDTO, LoanResponse.class);
    }

    // Check Loan Status
    public LoanStatus getLoanStatus(String loanId) {
        String url = "http://localhost:8080/mock-bank/loan/status/" + loanId;
        return restTemplate.getForObject(url, LoanStatus.class);
    }

    // Fetch Credit Score
    public CreditScoreDTO getCreditScore(String applicationId) {
        String url = "http://localhost:8080/mock-bank/credit-score/" + applicationId;
        return restTemplate.getForObject(url, CreditScoreDTO.class);
    }
}
