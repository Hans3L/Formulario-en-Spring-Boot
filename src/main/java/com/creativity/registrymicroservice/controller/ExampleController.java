package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/v2")
public class ExampleController {

    @GetMapping("/request1")
    public ModelAndView request(@RequestParam(value = "name", required = false, defaultValue = "null") String name){
        ModelAndView mav = new ModelAndView("example");
        mav.addObject("name_in_model",name);
        return mav;
    }

    @GetMapping("/request2/{nm}")
    public ModelAndView request2(@PathVariable(value = "nm") String name){
        ModelAndView mav = new ModelAndView("example");
        mav.addObject("name_in_model",name);
        return mav;
    }

    @GetMapping("/showform")
    public String getform(Model model){
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping("/addperson")
    public ModelAndView addPerson(@ModelAttribute("person") Person person){
        ModelAndView mav = new ModelAndView("result");
        mav.addObject("person",person);
        return mav;
    }

    //TODO @GetMapping("/")
    //TODO public String redirectOne(){
    //TODO    return "redirect:/v2/showform";
    //TODO }

    @GetMapping("/")
    public RedirectView redirect(){
        return new RedirectView("/v2/showform");
    }
}
