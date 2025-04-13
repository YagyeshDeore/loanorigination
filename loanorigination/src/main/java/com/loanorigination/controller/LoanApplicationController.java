package com.loanorigination.controller;

import com.loanorigination.dto.LoanApplicationDTO;
import com.loanorigination.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-applications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping
    public LoanApplicationDTO create(@RequestBody LoanApplicationDTO dto) {
        return loanApplicationService.createLoanApplication(dto);
    }

    @GetMapping
    public List<LoanApplicationDTO> getAll() {
        return loanApplicationService.getAllLoanApplications();
    }

    @GetMapping("/{id}")
    public LoanApplicationDTO getById(@PathVariable Long id) {
        return loanApplicationService.getLoanApplicationById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loanApplicationService.deleteLoanApplication(id);
    }
}
