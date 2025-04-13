package com.loanorigination.service.Impl;

import com.loanorigination.dto.DisbursementDTO;
import com.loanorigination.entity.Disbursement;
import com.loanorigination.repository.DisbursementRepository;
import com.loanorigination.service.DisbursementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisbursementServiceImpl implements DisbursementService {

    private final DisbursementRepository disbursementRepository;

    @Override
    public DisbursementDTO createDisbursement(DisbursementDTO dto) {
        Disbursement entity = new Disbursement();
        BeanUtils.copyProperties(dto, entity);
        Disbursement saved = disbursementRepository.save(entity);
        DisbursementDTO response = new DisbursementDTO();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    @Override
    public DisbursementDTO getDisbursementById(Long id) {
        return disbursementRepository.findById(id)
                .map(entity -> {
                    DisbursementDTO dto = new DisbursementDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }).orElse(null);
    }

    @Override
    public List<DisbursementDTO> getAllDisbursements() {
        return disbursementRepository.findAll().stream().map(entity -> {
            DisbursementDTO dto = new DisbursementDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteDisbursement(Long id) {
        disbursementRepository.deleteById(id);
    }
}
