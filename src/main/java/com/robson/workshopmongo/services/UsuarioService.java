package com.robson.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robson.workshopmongo.dominio.Usuario;
import com.robson.workshopmongo.repository.UsuarioRepository;
import com.robson.workshopmongo.services.exception.ObjectNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    
    UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(String id){
        Optional<Usuario> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException(id + " Not Found"));
    }

}
