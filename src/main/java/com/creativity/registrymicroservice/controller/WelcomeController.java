package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.component.ExampleComponent;
import com.creativity.registrymicroservice.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/v1")
public class WelcomeController {

    public static final String EXAMPLE = "index";

    @Autowired
    ExampleComponent exampleComponent;

    @GetMapping("/hello")
    public String ExampleIndex(Model model) {
        try{
            exampleComponent.sayHello();
            //int a = 6/0;
            model.addAttribute("people", getListPerson());
            return EXAMPLE;
        } catch (Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.MULTI_STATUS, "Error List Person",exc);

        }

    }

    @GetMapping("/farewell")
    public ModelAndView ExampleMAV() {
        ModelAndView mav = new ModelAndView(EXAMPLE);
        mav.addObject("people", getListPerson());
        return mav;
    }

    public List<Person> getListPerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("HANSEL", 25));
        list.add(new Person("Roman", 35));
        list.add(new Person("Frank", 50));
        list.add(new Person("Superman", 25));
        return list;
    }
}
