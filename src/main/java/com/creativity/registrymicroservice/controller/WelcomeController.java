package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/v1")
public class WelcomeController {

    public static final String EXAMPLE = "index";


    @GetMapping("/hello")
    public String ExampleIndex(Model model){
       model.addAttribute("people", getListPerson());
        return EXAMPLE;
    }

    @GetMapping("/farewell")
    public ModelAndView ExampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE);
        mav.addObject("people",getListPerson());
        return mav;
    }

    public List<Person> getListPerson(){
        List<Person>  list = new ArrayList<>();
        list.add(new Person("HANSEL",25));
        list.add(new Person("Roman",35));
        list.add(new Person("Frank",50));
        list.add(new Person("Superman",25));
        return list;
    }
}
