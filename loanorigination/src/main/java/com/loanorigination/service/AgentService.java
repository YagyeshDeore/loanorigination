package com.loanorigination.service;

import java.util.List;

import com.loanorigination.entity.Agent;

public interface AgentService {
    List<Agent> getAllAgents();
    void saveAgent(Agent agent);
    Agent getAgentById(Long id);
    void updateAgent(Agent agent);
    void deleteAgent(Long id);
}
