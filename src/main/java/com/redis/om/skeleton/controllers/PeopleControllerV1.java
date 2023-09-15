package com.redis.om.skeleton.controllers;

import com.redis.om.skeleton.models.Person;
import com.redis.om.skeleton.models.repositories.PeopleRepository;
import com.redis.om.skeleton.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleControllerV1 {
    @Autowired
    PeopleRepository repo;

    @Autowired
    PeopleService serv;

    @GetMapping("/all")
    Iterable<Person> all() {
        return repo.findAll();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @GetMapping("{id}")
    Optional<Person> byId(@PathVariable String id) {
        return repo.findById(id);
    }
}

