package com.loanorigination.service;

import com.loanorigination.dto.UnderWritingResultDTO;

import java.util.List;

public interface UnderWritingResultService {

    UnderWritingResultDTO getUnderWritingResult(Long loanApplicationId);
    List<UnderWritingResultDTO> getAllUnderWritingResults();
    UnderWritingResultDTO saveUnderWritingResult(UnderWritingResultDTO underWritingResultDTO);
}
