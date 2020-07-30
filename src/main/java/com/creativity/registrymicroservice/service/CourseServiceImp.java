package com.creativity.registrymicroservice.service;

import com.creativity.registrymicroservice.dto.CourseDto;
import com.creativity.registrymicroservice.entity.CourseEntity;
import com.creativity.registrymicroservice.repository.CourseRepository;
import com.creativity.registrymicroservice.util.CourseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseService")
public class CourseServiceImp implements CourseService {

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @Override
    public List<CourseDto> listAllCourses() {
        List<CourseEntity> courseEntities = courseRepository.findAll();
        List<CourseDto> courseDto = new ArrayList<>();
        for (CourseEntity course : courseEntities)
            courseDto.add(courseConverter.entityToCourseDto(course));
        return courseDto;
    }

    @Override
    public CourseEntity addCourse(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }

    @Override
    public void removeCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseEntity updateCourse(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }
}
