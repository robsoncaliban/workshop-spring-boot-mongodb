package com.robson.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.robson.workshopmongo.dominio.Usuario;
import com.robson.workshopmongo.dto.UsuarioDTO;
import com.robson.workshopmongo.services.UsuarioService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    private UsuarioService service;
    //@RequestMapping(method = RequestMethod.GET)  <- outra forma
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> listdDto = list.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listdDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
        Usuario usuario = service.findById(id);
        var usuarioDTO = new UsuarioDTO(usuario);
        return ResponseEntity.ok().body(usuarioDTO);
    }

}
