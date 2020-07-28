package com.creativity.registrymicroservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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


}
