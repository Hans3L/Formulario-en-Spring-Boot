package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.dto.UserCredentialDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.creativity.registrymicroservice.util.Contants.CONTACTS;
import static com.creativity.registrymicroservice.util.Contants.LOGIN;

@Controller
public class LoginController {

    Logger LOGGER = LogManager.getLogger(LoginController.class);

    @GetMapping("/")
    public String redirectToLogin(){
        LOGGER.info("ENTERING METHOD: redirectToLogin()");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "logout", required = false) String logout,
                                @RequestParam(name = "error", required = false)String error) {
        LOGGER.info("ENTERING METHOD: showLoginForm() -- PARAMS: error: " + error + " logout: " +logout);
        model.addAttribute("logout",logout);
        model.addAttribute("error",error);
        model.addAttribute("userCredentials", new UserCredentialDto());
        return LOGIN;
    }

    @PostMapping("/logincheck")
    public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredentialDto userCredentialDto){
        LOGGER.info("ENTERING METHOD: loginCheck() -- PARAMS: UserCredentialDto: " + userCredentialDto.toString() );
        if (userCredentialDto.getUsername().equals("user") && userCredentialDto.getPassword().equals("user")){
            LOGGER.info("Returning to contacts view");
            return "redirect:/contact/show-contact";
        }
        LOGGER.info("Redirect to login?error");
        return "redirect:/login?error";
    }
}
