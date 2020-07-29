package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.component.ExampleComponent;
import com.creativity.registrymicroservice.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/v1")
public class WelcomeController {

    public static final String EXAMPLE = "index";

    @Autowired
    ExampleComponent exampleComponent;

    @Autowired
    @Qualifier("exampleService")
    private ExampleService exampleService;

    @GetMapping("/hello")
    public String ExampleIndex(Model model) {
        try{
            exampleComponent.sayHello();
            //int a = 6/0;
            model.addAttribute("people", exampleService.getListPerson());
            return EXAMPLE;
        } catch (Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.MULTI_STATUS, "Error List Person",exc);
        }
    }

    @GetMapping("/farewell")
    public ModelAndView ExampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE);
        mav.addObject("people", exampleService.getListPerson());
        return mav;
    }

}
