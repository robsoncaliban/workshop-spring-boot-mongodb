package com.robson.workshopmongo.resources;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robson.workshopmongo.dominio.Post;
import com.robson.workshopmongo.resources.util.URL;
import com.robson.workshopmongo.services.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private PostService service;

    //@RequestMapping(method = RequestMethod.GET)  <- outra forma
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }
    @GetMapping(value = "/pesquisartitulo")
    public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "text", defaultValue = "") String texto){
        texto = URL.decodePram(texto);
        List<Post> posts = service.findByTitulo(texto);
        return ResponseEntity.ok().body(posts);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
