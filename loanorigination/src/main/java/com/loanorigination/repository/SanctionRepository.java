package com.loanorigination.repository;

import com.loanorigination.entity.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanctionRepository extends JpaRepository<Sanction, Long> {
    // Optional: add findByLoanApplicationId if needed
}
