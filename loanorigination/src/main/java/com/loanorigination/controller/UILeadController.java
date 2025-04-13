package com.loanorigination.controller;

import com.loanorigination.dto.LeadDTO;
import com.loanorigination.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/leads")
public class UILeadController {

    private final LeadService leadService;

    @GetMapping
    public String showLeadForm(Model model) {
        List<LeadDTO> leads = leadService.getAllLeads();
        model.addAttribute("leads", leads);
        return "leads";
    }

    @PostMapping
    public String createLead(@ModelAttribute LeadDTO leadDTO) {
        leadService.createLead(leadDTO);
        return "redirect:/leads";
    }
}
