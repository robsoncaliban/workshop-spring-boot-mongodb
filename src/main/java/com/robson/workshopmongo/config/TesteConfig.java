package com.robson.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.robson.workshopmongo.dominio.Comentario;
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

        var comentario01 = new Comentario(sdf.parse("10/11/2023"), "Boa viagem", new AutorDTO(alex));
        var comentario02 = new Comentario(sdf.parse("10/11/2023"), "Aproveite!", new AutorDTO(bob));
        var comentario03 = new Comentario(sdf.parse("13/11/2023"), "Tenha um otimo dia", new AutorDTO(alex));

        post01.getComentarios().addAll(Arrays.asList(comentario01,comentario02));
        post02.getComentarios().add(comentario03);

        postRepository.saveAll(Arrays.asList(post01,post02));
        maria.getPosts().addAll(Arrays.asList(post01,post02));
        usuarioRepository.save(maria);

    }
    
}
