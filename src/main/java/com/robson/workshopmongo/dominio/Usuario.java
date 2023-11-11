package com.robson.workshopmongo.dominio;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private String id;
    private String nome;
    private String email;

    public Usuario(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

}
