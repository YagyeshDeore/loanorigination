package com.loanorigination.service.Impl;

import com.loanorigination.dto.LeadAllocationDTO;
import com.loanorigination.entity.LeadAllocation;
import com.loanorigination.repository.LeadAllocationRepository;
import com.loanorigination.service.LeadAllocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeadAllocationServiceImpl implements LeadAllocationService {

    private final LeadAllocationRepository leadAllocationRepository;

    @Override
    public LeadAllocationDTO allocateLead(LeadAllocationDTO dto) {
        LeadAllocation entity = new LeadAllocation();
        BeanUtils.copyProperties(dto, entity);
        LeadAllocation saved = leadAllocationRepository.save(entity);
        LeadAllocationDTO response = new LeadAllocationDTO();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    @Override
    public LeadAllocationDTO getAllocationById(Long id) {
        return leadAllocationRepository.findById(id)
                .map(entity -> {
                    LeadAllocationDTO dto = new LeadAllocationDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }).orElse(null);
    }

    @Override
    public List<LeadAllocationDTO> getAllAllocations() {
        return leadAllocationRepository.findAll().stream().map(entity -> {
            LeadAllocationDTO dto = new LeadAllocationDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteAllocation(Long id) {
        leadAllocationRepository.deleteById(id);
    }
}
