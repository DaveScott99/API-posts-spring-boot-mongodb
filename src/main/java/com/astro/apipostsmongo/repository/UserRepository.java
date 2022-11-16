package com.astro.apipostsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.astro.apipostsmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
