package com.prueba.tecnica.enums;

public enum EnumResponse {
    OK("0", "OK"),
    ERROR("1", "Error"),
    BAD_REQUEST("400", "Bad Request"),
    NOT_FOUND("404", "Not Found");

    private final String code;
    private final String state;

    EnumResponse(String code, String state){
        this.code = code;
        this.state = state;
    }

    public String code(){
        return code;
    }

    public String state(){
        return state;
    }

}
