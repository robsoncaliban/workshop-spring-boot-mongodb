package com.robson.workshopmongo.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.robson.workshopmongo.dominio.Usuario;
import com.robson.workshopmongo.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class TesteConfig implements CommandLineRunner{

    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.deleteAll();

        var maria = new Usuario( "maria", "maria@gmail.com");
        var alex = new Usuario( "alex", "alex@gmail.com");
        var bob = new Usuario( "bob", "bob@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
    
}
