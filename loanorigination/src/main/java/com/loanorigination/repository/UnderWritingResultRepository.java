package com.loanorigination.repository;

import com.loanorigination.entity.UnderWritingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderWritingResultRepository extends JpaRepository<UnderWritingResult, Long> {

    // Add custom queries if needed
}
