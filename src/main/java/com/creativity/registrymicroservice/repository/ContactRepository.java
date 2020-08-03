package com.creativity.registrymicroservice.repository;

import com.creativity.registrymicroservice.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

    public ContactEntity findById(int id);

}
