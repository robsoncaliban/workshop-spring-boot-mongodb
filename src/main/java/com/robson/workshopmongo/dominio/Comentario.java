package com.robson.workshopmongo.dominio;

import java.io.Serializable;
import java.util.Date;

import com.robson.workshopmongo.dto.AutorDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comentario  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String texto;
    private Date data;
    private AutorDTO autor;

    public Comentario(Date data, String texto, AutorDTO autor) {
        this.texto = texto;
        this.data = data;
        this.autor = autor;
    }

    


}
