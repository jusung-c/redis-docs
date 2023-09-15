package com.redis.om.skeleton.services;

import com.redis.om.skeleton.models.Person;
import com.redis.om.skeleton.models.Person$;
import com.redis.om.spring.search.stream.EntityStream;
import io.redisearch.aggregation.SortedField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PeopleService {
    @Autowired
    EntityStream entityStream;

    // Find all people
    public Iterable<Person> findAllPeople(int minAge, int maxAge) {
        return entityStream //
                .of(Person.class) //
                .collect(Collectors.toList());
    }

    // Find people by age range
    public Iterable<Person> findByAgeBetween(int minAge, int maxAge) {
        return entityStream //
                .of(Person.class) //
                .filter(Person$.AGE.between(minAge, maxAge)) //
                .sorted(Person$.AGE, SortedField.SortOrder.ASC) //
                .collect(Collectors.toList());
    }
}