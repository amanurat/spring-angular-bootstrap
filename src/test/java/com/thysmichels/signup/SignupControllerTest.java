package com.thysmichels.signup;

import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.thysmichels.config.WebAppConfigurationAware;

public class SignupControllerTest extends WebAppConfigurationAware {
    @Test
    public void displaysSignupForm() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(model().attributeExists("signupForm"))
                .andExpect(view().name("login/login"))
                .andExpect(content().string(
                        allOf(
                                containsString("<h2 class=\"form-signin-heading\">Please sign up</h2>")
                                //containsString("<legend>Please Sign Up</legend>")
                        ))
                );
    }
}