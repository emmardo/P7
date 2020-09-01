package com.nhk.springboot.p7.controllers;

import com.nhk.springboot.p7.domain.BidList;
import com.nhk.springboot.p7.repositories.BidListRepository;
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
public class BidListController {
    // TODO: Inject Bid service
    @Autowired
    private BidListRepository bidListRepository;

    Logger logger = LoggerFactory.getLogger(BidListController.class);

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        // TODO: call service find all bids to show to the view

        model.addAttribute("bidLists", bidListRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /bidList/list request SUCCESSFUL from USER: " + authentication.getName());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /bidList/add request SUCCESSFUL from USER: " + authentication.getName());
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid @ModelAttribute("bidList")BidList bidList, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return bid list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!result.hasErrors()) {
            bidListRepository.save(bidList);
            model.addAttribute("bidLists", bidListRepository.findAll());
            logger.info("POST /bidList/validate request SUCCESSFUL from USER: " + authentication.getName());
            return "redirect:/bidList/list";
        }
        logger.error("POST /bidList/validate request UNSUCCESSFUL from USER: " + authentication.getName());
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form

        BidList bidList = bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bid list Id:" + id));
        model.addAttribute("bidList", bidList);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /bidList/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING BID LIST of ID: " + id);
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (result.hasErrors()) {
            logger.error("POST /bidList/update request UNSUCCESSFUL from USER: " + authentication.getName() + ", attempting to UPDATE BID LIST of ID: " + id);
            return "redirect:/bidList/list";
        }

        bidListRepository.save(bidList);
        model.addAttribute("bidLists", bidListRepository.findAll());
        logger.info("POST /bidList/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING BID LIST of ID: " + id);
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Bid by Id and delete the bid, return to Bid list

        BidList bidList = bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bid list Id:" + id));
        bidListRepository.delete(bidList);
        model.addAttribute("bidLists", bidListRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /bidList/delete request SUCCESSFUL from USER: " + authentication.getName() + ", DELETING BID LIST of ID: " + id);
        return "redirect:/bidList/list";
    }
}
