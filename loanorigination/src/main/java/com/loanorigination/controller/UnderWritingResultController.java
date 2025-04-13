package com.loanorigination.controller;

import com.loanorigination.dto.UnderWritingResultDTO;
import com.loanorigination.service.UnderWritingResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/underwriting-results")
public class UnderWritingResultController {

    @Autowired
    private UnderWritingResultService underWritingResultService;

    @GetMapping("/{loanApplicationId}")
    public UnderWritingResultDTO getUnderWritingResult(@PathVariable Long loanApplicationId) {
        return underWritingResultService.getUnderWritingResult(loanApplicationId);
    }

    @GetMapping
    public List<UnderWritingResultDTO> getAllUnderWritingResults() {
        return underWritingResultService.getAllUnderWritingResults();
    }

    @PostMapping
    public UnderWritingResultDTO saveUnderWritingResult(@RequestBody UnderWritingResultDTO underWritingResultDTO) {
        return underWritingResultService.saveUnderWritingResult(underWritingResultDTO);
    }
}
