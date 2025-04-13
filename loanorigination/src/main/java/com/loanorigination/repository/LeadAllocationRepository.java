package com.loanorigination.repository;

import com.loanorigination.entity.LeadAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadAllocationRepository extends JpaRepository<LeadAllocation, Long> {
}
