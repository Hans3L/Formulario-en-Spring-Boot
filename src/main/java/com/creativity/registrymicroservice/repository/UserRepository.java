package com.creativity.registrymicroservice.repository;

import com.creativity.registrymicroservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

    public abstract UserEntity findByUserName(String username);
}
