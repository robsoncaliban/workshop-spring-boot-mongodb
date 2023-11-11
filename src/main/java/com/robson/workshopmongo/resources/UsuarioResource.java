package com.robson.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robson.workshopmongo.dominio.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    
    @RequestMapping(method = RequestMethod.GET)
    // @GetMapping <- outra forma
    public ResponseEntity<List<Usuario>> findAll(){
        var maria = new Usuario("1", "maria", "maria@gmail.com");
        var jose = new Usuario("2", "jose", "jose@gmail.com");
        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,jose));
        return ResponseEntity.ok().body(list);
    }
}
