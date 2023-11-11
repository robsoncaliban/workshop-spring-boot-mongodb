package com.robson.workshopmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robson.workshopmongo.dominio.Usuario;
import com.robson.workshopmongo.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService {
    
    UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }
}
