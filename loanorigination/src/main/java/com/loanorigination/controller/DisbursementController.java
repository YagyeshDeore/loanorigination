package com.loanorigination.controller;

import com.loanorigination.dto.DisbursementDTO;
import com.loanorigination.service.DisbursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disbursements")
@RequiredArgsConstructor
public class DisbursementController {

    private final DisbursementService disbursementService;

    @PostMapping
    public DisbursementDTO create(@RequestBody DisbursementDTO dto) {
        return disbursementService.createDisbursement(dto);
    }

    @GetMapping("/{id}")
    public DisbursementDTO getById(@PathVariable Long id) {
        return disbursementService.getDisbursementById(id);
    }

    @GetMapping
    public List<DisbursementDTO> getAll() {
        return disbursementService.getAllDisbursements();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        disbursementService.deleteDisbursement(id);
    }
}
