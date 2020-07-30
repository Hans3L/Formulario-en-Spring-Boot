package com.creativity.registrymicroservice.controller;

import com.creativity.registrymicroservice.dto.CourseDto;
import com.creativity.registrymicroservice.service.CourseService;
import com.creativity.registrymicroservice.util.CourseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final String COURSE_VIEW = "courses";

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @GetMapping("/list/all-course")
    public ModelAndView listAllCourse(){
        ModelAndView mav = new ModelAndView(COURSE_VIEW);
        //Se crea un nuevo atributo con un contructor vacio para parsear en los objetos de thymeleaf
        CourseDto courseDto = new CourseDto();
        mav.addObject("course", courseConverter.dtoToCourseEntity(courseDto));
        mav.addObject(COURSE_VIEW,courseService.listAllCourses());
        return mav;
    }

    @PostMapping("/add-course")
    public RedirectView addCourse(@ModelAttribute("courseEntity") CourseDto courseDto){
        try{
            courseService.addCourse(courseConverter.dtoToCourseEntity(courseDto));
            return new RedirectView("/course/list/all-course");
        }catch (Exception ex){
            throw new ResponseStatusException(
                    HttpStatus.EXPECTATION_FAILED, "Error Internal", ex);
        }
    }
}
