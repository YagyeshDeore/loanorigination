package com.loanorigination.service.Impl;

import com.loanorigination.dto.UnderWritingResultDTO;
import com.loanorigination.entity.UnderWritingResult;
import com.loanorigination.repository.UnderWritingResultRepository;
import com.loanorigination.service.UnderWritingResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnderWritingResultServiceImpl implements UnderWritingResultService {

    @Autowired
    private UnderWritingResultRepository underWritingResultRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UnderWritingResultDTO getUnderWritingResult(Long loanApplicationId) {
        UnderWritingResult underWritingResult = underWritingResultRepository.findById(loanApplicationId)
                .orElseThrow(() -> new RuntimeException("Underwriting result not found"));
        return modelMapper.map(underWritingResult, UnderWritingResultDTO.class);
    }

    @Override
    public List<UnderWritingResultDTO> getAllUnderWritingResults() {
        return underWritingResultRepository.findAll()
                .stream()
                .map(result -> modelMapper.map(result, UnderWritingResultDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UnderWritingResultDTO saveUnderWritingResult(UnderWritingResultDTO underWritingResultDTO) {
        UnderWritingResult underWritingResult = modelMapper.map(underWritingResultDTO, UnderWritingResult.class);
        UnderWritingResult savedUnderWritingResult = underWritingResultRepository.save(underWritingResult);
        return modelMapper.map(savedUnderWritingResult, UnderWritingResultDTO.class);
    }
}
