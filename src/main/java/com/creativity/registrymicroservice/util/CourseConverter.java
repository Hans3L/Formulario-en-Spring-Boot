package com.creativity.registrymicroservice.util;


import com.creativity.registrymicroservice.dto.CourseDto;
import com.creativity.registrymicroservice.entity.CourseEntity;

public class CourseConverter {

    public CourseEntity dtoToCourseEntity(CourseDto courseDto){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(courseDto.getName());
        courseEntity.setDescription(courseDto.getDescription());
        courseEntity.setPrice(courseDto.getPrice());
        courseEntity.setHour(courseDto.getHour());
        return courseEntity;
    }

    public CourseDto entityToCourseDto(CourseEntity courseEntity){
        CourseDto courseDto = new CourseDto();
        courseDto.setName(courseEntity.getName());
        courseDto.setDescription(courseEntity.getDescription());
        courseDto.setPrice(courseEntity.getPrice());
        courseDto.setHour(courseEntity.getHour());
        return courseDto;
    }
}
