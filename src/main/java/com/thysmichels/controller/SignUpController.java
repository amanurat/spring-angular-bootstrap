package com.thysmichels.controller;

import com.thysmichels.model.Account;
import com.thysmichels.repository.jpa.AccountRepository;
import com.thysmichels.service.UserService;
import com.thysmichels.signup.SignupForm;
import com.thysmichels.support.web.MessageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SignUpController {

    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    private static final String SIGNUP_VIEW_NAME = "login/login";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signup")
    public String loginPage(Model model) {
        model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
        System.out.println(signupForm.getEmail());
        System.out.println(signupForm.getPassword());
        if (errors.hasErrors()) {
            System.out.println("ERRORS: " + errors.getAllErrors().toString());
            logger.error(errors.getAllErrors().toString());
            return SIGNUP_VIEW_NAME;
        }

        Account account = accountRepository.findByEmail(signupForm.getEmail());
        System.out.println("ACCOUNT: " + account);
        if (account==null){
            System.out.println("New");
            accountRepository.save(signupForm.createAccount());
            userService.signin(account);
        } else {
            System.out.println("Already");
            userService.signin(account);
        }

        MessageHelper.addSuccessAttribute(ra, "signup.success");
        System.out.println("HIER RETURN");
        return "redirect:/";
    }
}
