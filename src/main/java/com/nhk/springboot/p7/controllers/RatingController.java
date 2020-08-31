package com.nhk.springboot.p7.controllers;

import com.nhk.springboot.p7.domain.Rating;
import com.nhk.springboot.p7.repositories.RatingRepository;
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
public class RatingController {
    // TODO: Inject Rating service

    @Autowired
    private RatingRepository ratingRepository;

    Logger logger = LoggerFactory.getLogger(RatingController.class);

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model

        model.addAttribute("ratings", ratingRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /rating/list request SUCCESSFUL from USER: " + authentication.getName());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /rating/add request SUCCESSFUL from USER: " + authentication.getName());
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!result.hasErrors()) {
            ratingRepository.save(rating);
            model.addAttribute("ratings", ratingRepository.findAll());
            logger.info("POST /rating/validate request SUCCESSFUL from USER: " + authentication.getName());
            return "redirect:/rating/list";
        }
        logger.error("POST /rating/validate request UNSUCCESSFUL from USER: " + authentication.getName());
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form

        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
        model.addAttribute("rating", rating);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /rating/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING RATING of ID: " + id);
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (result.hasErrors()) {
            logger.error("POST /rating/update request UNSUCCESSFUL from USER: " + authentication.getName() + ", attempting to UPDATE RATING of ID: " + id);
            return "redirect:/rating/list";
        }

        ratingRepository.save(rating);
        model.addAttribute("ratings", ratingRepository.findAll());
        logger.info("POST /rating/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING RATING of ID: " + id);
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list

        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
        ratingRepository.delete(rating);
        model.addAttribute("ratings", ratingRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /rating/delete request SUCCESSFUL from USER: " + authentication.getName() + ", DELETING RATING of ID: " + id);
        return "redirect:/rating/list";
    }
}
