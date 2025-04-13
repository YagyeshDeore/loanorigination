package com.loanorigination.service;

import com.loanorigination.dto.DisbursementDTO;

import java.util.List;

public interface DisbursementService {
    DisbursementDTO createDisbursement(DisbursementDTO dto);
    DisbursementDTO getDisbursementById(Long id);
    List<DisbursementDTO> getAllDisbursements();
    void deleteDisbursement(Long id);
}
