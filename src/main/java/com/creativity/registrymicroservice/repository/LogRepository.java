package com.creativity.registrymicroservice.repository;

import com.creativity.registrymicroservice.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<LogEntity, Serializable> {
}
