package com.prueba.tecnica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> extends ResponseModel {
    private static final long serialVersionUID = 1L;

    private T data;

    public ResponseData() {
        super();
    }

    public ResponseData(String code) {
        super(code);
    }
    public ResponseData(String code, String message, T data) {
        super(code);
        this.setMessage(message);
        this.data = data;
    }

    // ✅ OK estándar
    public static <T> ResponseData<T> ok(T data) {
        return new ResponseData<>("0", "OK", data);
    }

    public static <T> ResponseData<T> ok(String message, T data) {
        return new ResponseData<>("0", message, data);
    }

    public static <T> ResponseData<T> fail(String code, String message) {
        return new ResponseData<>(code, message, null);
    }


}
