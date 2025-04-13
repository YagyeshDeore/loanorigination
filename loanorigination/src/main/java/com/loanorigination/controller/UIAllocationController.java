package com.loanorigination.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loanorigination.dto.LeadAllocationDTO;
import com.loanorigination.service.LeadAllocationService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UIAllocationController {

    private final LeadAllocationService allocationService;

    @GetMapping("/allocations")
    public String showAllocations(Model model) {
        List<Allocation> allocations = allocationService.getAllAllocations();
        if (allocations != null) {
            model.addAttribute("allocations", allocations);
        } else {
            model.addAttribute("allocations", new ArrayList<>());
        }
        return "allocations";
    }


    @PostMapping("/allocations")
    public String allocate(@RequestParam Long leadId,
                           @RequestParam Long agentId) {
        LeadAllocationDTO dto = LeadAllocationDTO.builder()
                .leadId(leadId)
                .agentId(agentId)
                .allocatedAt(LocalDateTime.now())
                .build();
        allocationService.allocateLead(dto);
        return "redirect:/allocations";
    }
}
