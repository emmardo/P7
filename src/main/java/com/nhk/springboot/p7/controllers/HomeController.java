package com.nhk.springboot.p7.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model)
	{
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model)
	{

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		logger.info("GET /admin/home request SUCCESSFUL from USER: " + authentication.getName());
		return "redirect:/bidList/list";
	}


}
