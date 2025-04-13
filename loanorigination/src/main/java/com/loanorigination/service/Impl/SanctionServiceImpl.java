package com.loanorigination.service.Impl;

import com.loanorigination.dto.SanctionDTO;
import com.loanorigination.entity.Sanction;
import com.loanorigination.repository.SanctionRepository;
import com.loanorigination.service.SanctionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanctionServiceImpl implements SanctionService {

    @Autowired
    private SanctionRepository sanctionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SanctionDTO getSanction(Long id) {
        Sanction sanction = sanctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sanction not found"));
        return modelMapper.map(sanction, SanctionDTO.class);
    }

    @Override
    public List<SanctionDTO> getAllSanctions() {
        return sanctionRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SanctionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SanctionDTO saveSanction(SanctionDTO sanctionDTO) {
        Sanction sanction = modelMapper.map(sanctionDTO, Sanction.class);
        Sanction saved = sanctionRepository.save(sanction);
        return modelMapper.map(saved, SanctionDTO.class);
    }
}
