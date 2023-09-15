package com.redis.om.skeleton.models.repositories;

import com.redis.om.skeleton.models.Person;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface PeopleRepository extends RedisDocumentRepository<Person,String> {

}