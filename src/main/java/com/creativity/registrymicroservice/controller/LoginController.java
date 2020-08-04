package com.creativity.registrymicroservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.creativity.registrymicroservice.util.Contants.LOGIN;

@Controller
public class LoginController {

    Logger LOGGER = LogManager.getLogger(LoginController.class);

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "logout", required = false) String logout,
                                @RequestParam(name = "error", required = false)String error) {
        LOGGER.info("ENTERING METHOD: showLoginForm() -- PARAMS: error: " + error + " logout: " +logout);
        model.addAttribute("logout",logout);
        model.addAttribute("error",error);
        LOGGER.info("Returning to login");
        return LOGIN;
    }

    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck(){
        LOGGER.info("ENTERING METHOD: loginCheck()");
        LOGGER.info("Returning to contacts view");
        return "redirect:/contact/show-contact";
    }
}
