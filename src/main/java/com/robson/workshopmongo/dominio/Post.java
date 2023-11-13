package com.robson.workshopmongo.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.robson.workshopmongo.dto.AutorDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "post")
public class Post implements Serializable{
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private Date data;
    private String titulo;
    private String corpo;
    private AutorDTO autor;

    private List<Comentario> comentarios = new ArrayList<>();

    public Post(Date data, String titulo, String corpo, AutorDTO autor) {
        this.data = data;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

}
