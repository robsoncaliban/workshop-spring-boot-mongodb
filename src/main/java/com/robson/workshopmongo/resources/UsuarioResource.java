package com.robson.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    // <- outra forma
    // @GetMapping
    @RequestMapping(method = RequestMethod.GET) 
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> listdDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listdDto);
    }
}
