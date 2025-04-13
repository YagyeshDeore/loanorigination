package com.loanorigination.service.Impl;

import com.loanorigination.dto.LoanApplicationDTO;
import com.loanorigination.entity.LoanApplication;
import com.loanorigination.repository.LoanApplicationRepository;
import com.loanorigination.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplicationDTO createLoanApplication(LoanApplicationDTO dto) {
        LoanApplication entity = LoanApplication.builder()
                .applicantName(dto.getApplicantName())
                .loanType(dto.getLoanType())
                .amount(dto.getAmount())
                .status(dto.getStatus())
                .build();

        LoanApplication saved = loanApplicationRepository.save(entity);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public List<LoanApplicationDTO> getAllLoanApplications() {
        return loanApplicationRepository.findAll()
                .stream()
                .map(e -> LoanApplicationDTO.builder()
                        .id(e.getId())
                        .applicantName(e.getApplicantName())
                        .loanType(e.getLoanType())
                        .amount(e.getAmount())
                        .status(e.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public LoanApplicationDTO getLoanApplicationById(Long id) {
        LoanApplication e = loanApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan Application not found"));

        return LoanApplicationDTO.builder()
                .id(e.getId())
                .applicantName(e.getApplicantName())
                .loanType(e.getLoanType())
                .amount(e.getAmount())
                .status(e.getStatus())
                .build();
    }

    @Override
    public void deleteLoanApplication(Long id) {
        loanApplicationRepository.deleteById(id);
    }
}
