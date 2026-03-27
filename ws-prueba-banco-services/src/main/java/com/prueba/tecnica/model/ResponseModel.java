package com.prueba.tecnica.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    public ResponseModel() {}

    public ResponseModel(String code) {
        this.code = code;
    }

    public ResponseModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
