package com.loanorigination.service;

import com.loanorigination.dto.SanctionDTO;

import java.util.List;

public interface SanctionService {
    SanctionDTO getSanction(Long id);
    List<SanctionDTO> getAllSanctions();
    SanctionDTO saveSanction(SanctionDTO sanctionDTO);
}
