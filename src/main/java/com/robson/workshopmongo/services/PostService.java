package com.robson.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robson.workshopmongo.dominio.Post;
import com.robson.workshopmongo.repository.PostRepository;
import com.robson.workshopmongo.services.exception.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
    
    PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id + " Not Found"));
    }

    public void delete(String id){
        var post = findById(id);
        repository.delete(post);
    }

}
