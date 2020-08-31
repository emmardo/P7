package com.nhk.springboot.p7.controllers;


import com.nhk.springboot.p7.domain.RuleName;
import com.nhk.springboot.p7.repositories.RuleNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RuleNameController {
    // TODO: Inject RuleName service

    @Autowired
    private RuleNameRepository ruleNameRepository;

    Logger logger = LoggerFactory.getLogger(RuleNameController.class);

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model

        model.addAttribute("ruleNames", ruleNameRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /ruleName/list request SUCCESSFUL from USER: " + authentication.getName());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /ruleName/add request SUCCESSFUL from USER: " + authentication.getName());
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!result.hasErrors()) {
            ruleNameRepository.save(ruleName);
            model.addAttribute("ruleNames", ruleNameRepository.findAll());
            logger.info("POST /ruleName/validate request SUCCESSFUL from USER: " + authentication.getName());
            return "redirect:/ruleName/list";
        }
        logger.error("POST /ruleName/validate request UNSUCCESSFUL from USER: " + authentication.getName());
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form

        RuleName ruleName = ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rule name Id:" + id));
        model.addAttribute("ruleName", ruleName);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /ruleName/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING RULE NAME of ID: " + id);
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (result.hasErrors()) {
            logger.error("POST /ruleName/update request UNSUCCESSFUL from USER: " + authentication.getName() + ", attempting to UPDATE RULE NAME of ID: " + id);
            return "redirect:/ruleName/list";
        }

        ruleNameRepository.save(ruleName);
        model.addAttribute("ruleNames", ruleNameRepository.findAll());
        logger.info("POST /ruleName/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING RULE NAME of ID: " + id);
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list

        RuleName ruleName = ruleNameRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rule name Id:" + id));
        ruleNameRepository.delete(ruleName);
        model.addAttribute("ruleNames", ruleNameRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /ruleName/delete request SUCCESSFUL from USER: " + authentication.getName() + ", DELETING RULE NAME of ID: " + id);
        return "redirect:/ruleName/list";
    }
}
