package com.robson.workshopmongo.services;

import java.util.Date;
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

    public List<Post> fullSearch(String text, Date minData, Date maxData){
        maxData = new Date(maxData.getTime() +20*60*60*1000);
        return repository.fullSearch(text, minData, maxData);
    }

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException(id + " Not Found"));
    }

    public List<Post> findByTitulo(String titulo){
        return repository.findByTitulo(titulo);
    }

    public void delete(String id){
        var post = findById(id);
        repository.delete(post);
    }

}
