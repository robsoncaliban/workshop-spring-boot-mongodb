package com.robson.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.robson.workshopmongo.dominio.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{}
