package com.astro.apipostsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.astro.apipostsmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
