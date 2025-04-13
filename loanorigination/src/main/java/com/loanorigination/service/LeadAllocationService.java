package com.loanorigination.service;

import com.loanorigination.dto.LeadAllocationDTO;

import java.util.List;

public interface LeadAllocationService {
    LeadAllocationDTO allocateLead(LeadAllocationDTO dto);
    LeadAllocationDTO getAllocationById(Long id);
    List<LeadAllocationDTO> getAllAllocations();
    void deleteAllocation(Long id);
}
