
package com.loanorigination.service.Impl;

import com.loanorigination.dto.LeadDTO;
import com.loanorigination.entity.Lead;
import com.loanorigination.repository.LeadRepository;
import com.loanorigination.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    private LeadRepository leadRepository;

    private Lead toEntity(LeadDTO dto) {
        return Lead.builder()
                .id(dto.getId())
                .full_name(dto.getFull_name())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .source(dto.getSource())
                .status(dto.getStatus())
                .created_at(dto.getCreated_at())
                .build();
    }

    private LeadDTO toDTO(Lead lead) {
        return LeadDTO.builder()
                .id(lead.getId())
                .full_name(lead.getFull_name())
                .email(lead.getEmail())
                .phone(lead.getPhone())
                .source(lead.getSource())
                .status(lead.getStatus())
                .created_at(lead.getCreated_at())
                .build();
    }

    @Override
    public LeadDTO createLead(LeadDTO leadDTO) {
        return toDTO(leadRepository.save(toEntity(leadDTO)));
    }

    @Override
    public List<LeadDTO> getAllLeads() {
        return leadRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
}
