package com.thysmichels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tmichels on 8/10/14.
 */

@Controller
public class LoginController {

    private static final String SIGNUP_VIEW_NAME = "login/login";

    @RequestMapping("login")
    public String login(){
        return SIGNUP_VIEW_NAME;
    }

}
