package com.creativity.registrymicroservice.service;

import com.creativity.registrymicroservice.dto.CourseDto;
import com.creativity.registrymicroservice.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    public abstract List<CourseDto> listAllCourses();
    public abstract CourseEntity addCourse(CourseEntity courseEntity);
    public abstract void removeCourse(int id);
    public abstract CourseEntity updateCourse(CourseEntity courseEntity);
}
