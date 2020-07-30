package com.creativity.registrymicroservice.repository;

import com.creativity.registrymicroservice.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("courseRepository")
public interface CourseRepository extends CrudRepository<CourseEntity, Serializable> {

    public abstract CourseEntity findByPrice(int price);

    public abstract CourseEntity countByPrice();

    public abstract CourseEntity findByNameOrAndId(String name , int id);
}
