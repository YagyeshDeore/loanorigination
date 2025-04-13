
package com.loanorigination.repository;

import com.loanorigination.entity.Agent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
    // Method to find agent by region
    List<Agent> findByRegion(String region);
}
