package com.creativity.registrymicroservice.service;

import com.creativity.registrymicroservice.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImp implements ExampleService{

    @Override
    public List<Person> getListPerson() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("HANSEL", 25));
            list.add(new Person("Roman", 35));
            list.add(new Person("Frank", 50));
            list.add(new Person("Superman", 25));
            return list;

    }
}
