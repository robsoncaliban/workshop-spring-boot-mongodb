package com.robson.workshopmongo.dto;

import java.io.Serializable;

import com.robson.workshopmongo.dominio.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AutorDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;

    public AutorDTO(Usuario usuario){
        id = usuario.getId();
        nome = usuario.getNome();
    }

}
