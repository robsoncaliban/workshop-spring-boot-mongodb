package com.robson.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.robson.workshopmongo.dominio.Post;
import com.robson.workshopmongo.dominio.Usuario;
import com.robson.workshopmongo.dto.AutorDTO;
import com.robson.workshopmongo.repository.PostRepository;
import com.robson.workshopmongo.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class TesteConfig implements CommandLineRunner{

    private UsuarioRepository usuarioRepository;
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        var maria = new Usuario( "maria", "maria@gmail.com");
        var alex = new Usuario( "alex", "alex@gmail.com");
        var bob = new Usuario( "bob", "bob@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        var post01 = new Post(sdf.parse("10/11/2023"), "Partiu viagem", 
            "Indo para sao paulo agora", new AutorDTO(maria));
        var post02 = new Post(sdf.parse("13/11/2023"), "Bom dia!",
            "Acordei feliz hoje!", new AutorDTO(maria));
        
        postRepository.saveAll(Arrays.asList(post01,post02));
        maria.getPosts().addAll(Arrays.asList(post01,post02));

    }
    
}
