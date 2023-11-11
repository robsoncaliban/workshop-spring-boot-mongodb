package com.robson.workshopmongo.resources.exeception;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;
    
 
    private Long timestamp;
    private Integer status;
    private String error;
    private String msg;
    private String path;

    public StandardError(Long timestamp, Integer status, String error, String msg, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.msg = msg;
        this.path = path;
    }

    

}
