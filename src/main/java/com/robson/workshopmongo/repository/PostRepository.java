package com.robson.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.robson.workshopmongo.dominio.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    @Query("{ 'titulo' : { $regex : ?0, $options: 'i' }}")
    List<Post> findByTitulo(String texto);

    List<Post> findByTituloContainingIgnoreCase(String texto);

}
