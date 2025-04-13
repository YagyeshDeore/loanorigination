package com.loanorigination.service;

import com.loanorigination.dto.LoanApplicationDTO;

import java.util.List;

public interface LoanApplicationService {
    LoanApplicationDTO createLoanApplication(LoanApplicationDTO loanApplicationDTO);
    List<LoanApplicationDTO> getAllLoanApplications();
    LoanApplicationDTO getLoanApplicationById(Long id);
    void deleteLoanApplication(Long id);
}
