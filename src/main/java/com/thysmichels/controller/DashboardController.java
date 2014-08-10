package com.thysmichels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tmichels on 8/9/14.
 */

@Controller
public class DashboardController {

    private static final String DASHBOARD_VIEW = "dashboard/dashboard";

    @RequestMapping("dashboard")
    public String dashboard(){
        return DASHBOARD_VIEW;
    }
}
