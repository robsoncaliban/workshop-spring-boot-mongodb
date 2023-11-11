package com.robson.workshopmongo.dto;

import java.io.Serializable;

import com.robson.workshopmongo.dominio.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nome;
    private String email;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Usuario fromDTO(){
        return new Usuario(getNome(), getEmail());
    }


}
