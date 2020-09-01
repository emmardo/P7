package com.nhk.springboot.p7.controllers;

import com.nhk.springboot.p7.domain.CurvePoint;
import com.nhk.springboot.p7.repositories.CurvePointRepository;
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
public class CurveController {
    // TODO: Inject Curve Point service

    @Autowired
    private CurvePointRepository curvePointRepository;

    Logger logger = LoggerFactory.getLogger(CurveController.class);

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        // TODO: find all Curve Point, add to model

        model.addAttribute("curvePoints", curvePointRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /curvePoint/list request SUCCESSFUL from USER: " + authentication.getName());
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /curvePoint/add request SUCCESSFUL from USER: " + authentication.getName());
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid @ModelAttribute("curvePoint")CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!result.hasErrors()) {
            curvePointRepository.save(curvePoint);
            model.addAttribute("curvePoints", curvePointRepository.findAll());
            logger.info("POST /curvePoint/validate request SUCCESSFUL from USER: " + authentication.getName());
            return "redirect:/curvePoint/list";
        }
        logger.error("POST /curvePoint/validate request UNSUCCESSFUL from USER: " + authentication.getName());
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form

        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curve point Id:" + id));
        model.addAttribute("curvePoint", curvePoint);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /curvePoint/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING CURVE POINT of ID: " + id);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (result.hasErrors()) {
            logger.error("POST /curvePoint/update request UNSUCCESSFUL from USER: " + authentication.getName() + ", attempting to UPDATE CURVE POINT of ID: " + id);
            return "redirect:/curvePoint/list";
        }

        curvePointRepository.save(curvePoint);
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        logger.info("POST /curvePoint/update request SUCCESSFUL from USER: " + authentication.getName() + ", UPDATING CURVE POINT of ID: " + id);
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list

        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curve point Id:" + id));
        curvePointRepository.delete(curvePoint);
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info("GET /curvePoint/delete request SUCCESSFUL from USER: " + authentication.getName() + ", DELETING CURVE POINT of ID: " + id);
        return "redirect:/curvePoint/list";
    }
}
