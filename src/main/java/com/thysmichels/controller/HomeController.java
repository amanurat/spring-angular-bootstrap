package com.thysmichels.controller;

import java.security.Principal;

import com.thysmichels.signup.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
        model.addAttribute(new SignupForm());
        return principal != null ? "dashboard/dashboard" : "login/login";
	}
}
