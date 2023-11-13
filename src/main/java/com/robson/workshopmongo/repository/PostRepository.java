package com.robson.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robson.workshopmongo.dominio.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{}
