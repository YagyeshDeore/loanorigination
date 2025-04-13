package com.loanorigination.controller;

import com.loanorigination.dto.SanctionDTO;
import com.loanorigination.service.SanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanctions")
public class SanctionController {

    @Autowired
    private SanctionService sanctionService;

    @GetMapping("/{id}")
    public SanctionDTO getSanction(@PathVariable Long id) {
        return sanctionService.getSanction(id);
    }

    @GetMapping
    public List<SanctionDTO> getAllSanctions() {
        return sanctionService.getAllSanctions();
    }

    @PostMapping
    public SanctionDTO saveSanction(@RequestBody SanctionDTO sanctionDTO) {
        return sanctionService.saveSanction(sanctionDTO);
    }
}
