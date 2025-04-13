package com.loanorigination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loanorigination.entity.Agent;
import com.loanorigination.service.AgentService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/agent")
public class UIAgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping("/list")
    public String listAgents(Model model) {
        List<Agent> agents = agentService.getAllAgents();
        model.addAttribute("agents", agents);
        return "agent_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("agent", new Agent());
        return "agent_add";
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("agent") Agent agent) {
        agentService.saveAgent(agent);
        return "redirect:/agent/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Agent agent = agentService.getAgentById(id);
        model.addAttribute("agent", agent);
        return "agent_edit";
    }

    @PostMapping("/update/{id}")
    public String updateAgent(@PathVariable("id") Long id, @ModelAttribute("agent") Agent agent) {
        agent.setId(id);
        agentService.updateAgent(agent);
        return "redirect:/agent/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteAgent(@PathVariable("id") Long id) {
        agentService.deleteAgent(id);
        return "redirect:/agent/list";
    }
}
