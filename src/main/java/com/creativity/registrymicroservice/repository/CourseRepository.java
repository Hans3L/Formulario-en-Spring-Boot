package com.creativity.registrymicroservice.repository;

import com.creativity.registrymicroservice.dto.CourseDto;
import com.creativity.registrymicroservice.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<CourseEntity, Serializable> {

    public abstract List<CourseDto> findAllBy();

    public abstract CourseEntity findByPrice(int price);

    public abstract CourseEntity deleteById(int id);

    public abstract CourseEntity findByNameOrAndId(String name , int id);
}
