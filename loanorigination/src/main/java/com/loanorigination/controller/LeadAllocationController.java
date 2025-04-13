package com.loanorigination.controller;

import com.loanorigination.dto.LeadAllocationDTO;
import com.loanorigination.service.LeadAllocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lead-allocations")
@RequiredArgsConstructor
public class LeadAllocationController {

    private final LeadAllocationService leadAllocationService;

    @PostMapping
    public LeadAllocationDTO allocate(@RequestBody LeadAllocationDTO dto) {
        return leadAllocationService.allocateLead(dto);
    }

    @GetMapping("/{id}")
    public LeadAllocationDTO getById(@PathVariable Long id) {
        return leadAllocationService.getAllocationById(id);
    }

    @GetMapping
    public List<LeadAllocationDTO> getAll() {
        return leadAllocationService.getAllAllocations();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        leadAllocationService.deleteAllocation(id);
    }
}
