package com.robson.workshopmongo.services.exception;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable{
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String mensagem) {
        super(mensagem);
    }
}
