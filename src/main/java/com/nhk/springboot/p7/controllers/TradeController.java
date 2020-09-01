package com.nhk.springboot.p7.controllers;

import com.nhk.springboot.p7.domain.Trade;
import com.nhk.springboot.p7.repositories.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TradeController {
    // TODO: Inject Trade service

    @Autowired
    private TradeRepository tradeRepository;

    Logger logger = LoggerFactory.getLogger(TradeController.class);

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model

        model.addAttribute("trades", tradeRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /trade/list request SUCCESSFUL from USER: " + authentication.getName());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /trade/add request SUCCESSFUL from USER: " + authentication.getName());
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid @ModelAttribute("trade")Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!result.hasErrors()) {
            tradeRepository.save(trade);
            model.addAttribute("trades", tradeRepository.findAll());
            logger.info("POST /trade/validate request SUCCESSFUL from USER: " + authentication.getName());
            return "redirect:/trade/list";
        }
        logger.error("POST /trade/validate request UNSUCCESSFUL from USER: " + authentication.getName());
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form

        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        model.addAttribute("trade", trade);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /trade/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING TRADE of ID: " + id);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (result.hasErrors()) {
            logger.error("POST /trade/update request UNSUCCESSFUL from USER: " + authentication.getName() + ", attempting to UPDATE TRADE of ID: " + id);
            return "redirect:/trade/list";
        }

        tradeRepository.save(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        logger.info("POST /trade/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING TRADE of ID: " + id);
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list

        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid trade Id:" + id));
        tradeRepository.delete(trade);
        model.addAttribute("trades", tradeRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /trade/delete request SUCCESSFUL from USER: " + authentication.getName() + ", DELETING TRADE of ID: " + id);
        return "redirect:/trade/list";
    }
}
