package com.loanorigination.service.Impl;

import com.loanorigination.dto.CreditScoreDTO;
import com.loanorigination.entity.CreditScore;
import com.loanorigination.repository.CreditScoreRepository;
import com.loanorigination.service.CreditScoreService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    @Autowired
    private CreditScoreRepository creditScoreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CreditScoreDTO getCreditScore(Long leadId) {
        CreditScore creditScore = creditScoreRepository.findById(leadId)
                .orElseThrow(() -> new RuntimeException("Credit score not found"));
        return modelMapper.map(creditScore, CreditScoreDTO.class);
    }

    @Override
    public List<CreditScoreDTO> getAllCreditScores() {
        return creditScoreRepository.findAll()
                .stream()
                .map(creditScore -> modelMapper.map(creditScore, CreditScoreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CreditScoreDTO saveCreditScore(CreditScoreDTO creditScoreDTO) {
        CreditScore creditScore = modelMapper.map(creditScoreDTO, CreditScore.class);
        CreditScore savedCreditScore = creditScoreRepository.save(creditScore);
        return modelMapper.map(savedCreditScore, CreditScoreDTO.class);
    }
}
