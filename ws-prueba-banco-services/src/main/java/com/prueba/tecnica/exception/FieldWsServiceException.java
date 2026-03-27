package com.prueba.tecnica.exception;

import com.prueba.tecnica.enums.EnumResponse;
import com.prueba.tecnica.model.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
@Slf4j
public class FieldWsServiceException extends RuntimeException{
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseData<Object>> badRequest(IllegalArgumentException e) {
        log.warn("BadRequest: {}", e.getMessage(), e);

        ResponseData<Object> res = new ResponseData<>(EnumResponse.ERROR.code());
        res.setMessage(e.getMessage());
        res.setData(null);

        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseData<Object>> notFound(NoSuchElementException e) {
        log.warn("NotFound: {}", e.getMessage(), e);

        // ✅ usa un code real (te recomiendo agregar NOT_FOUND al enum)
        ResponseData<Object> res = new ResponseData<>(EnumResponse.ERROR.code());
        res.setMessage(e.getMessage());
        res.setData(null);

        return ResponseEntity.status(404).body(res);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData<Object>> internalError(Exception e) {
        log.error("InternalError:", e);

        ResponseData<Object> res = new ResponseData<>(EnumResponse.ERROR.code());
        res.setMessage("Ocurrió un error interno.");
        res.setData(null);

        return ResponseEntity.status(500).body(res);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResource(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("code","404","message","Not found"));
    }
}
