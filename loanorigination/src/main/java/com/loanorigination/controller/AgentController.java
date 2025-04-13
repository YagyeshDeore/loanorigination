package com.loanorigination.controller;

import com.loanorigination.entity.Agent;
import com.loanorigination.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping("/region/{region}")
    public List<Agent> getAgentsByRegion(@PathVariable String region) {
        return agentService.getAgentsByRegion(region);
    }

    @PostMapping("/assign/{leadId}/{region}")
    public Agent assignLeadToAgent(@PathVariable Long leadId, @PathVariable String region) {
        return agentService.assignLeadToAgent(leadId, region);
    }
}
