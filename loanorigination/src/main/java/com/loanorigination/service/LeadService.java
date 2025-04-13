package com.loanorigination.service;

import com.loanorigination.dto.LeadDTO;
import java.util.List;

public interface LeadService {
    LeadDTO createLead(LeadDTO leadDTO);
    List<LeadDTO> getAllLeads();
}
