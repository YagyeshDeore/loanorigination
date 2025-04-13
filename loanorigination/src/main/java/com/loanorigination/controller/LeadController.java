package com.loanorigination.controller;

import com.loanorigination.dto.LeadDTO;
import com.loanorigination.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public LeadDTO createLead(@RequestBody LeadDTO leadDTO) {
        return leadService.createLead(leadDTO);
    }

    @GetMapping
    public List<LeadDTO> getAllLeads() {
        return leadService.getAllLeads();
    }
}
