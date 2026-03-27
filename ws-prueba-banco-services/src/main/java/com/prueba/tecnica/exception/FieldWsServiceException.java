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

/**
 * Clase encargada de manejar de forma global todas las excepciones
 * generadas en los controladores REST de la aplicación.
 *
 * Utiliza la anotación @RestControllerAdvice para interceptar errores
 * y devolver respuestas estructuradas al cliente.
 */
@RestControllerAdvice
@Slf4j
public class FieldWsServiceException{

     /**
     * Maneja excepciones de tipo IllegalArgumentException.
     * Generalmente se producen cuando los parámetros enviados
     * por el cliente son inválidos.
     *
     * Retorna una respuesta HTTP 400 (Bad Request).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseData<Object>> badRequest(IllegalArgumentException e) {
        log.warn("BadRequest: {}", e.getMessage(), e);

        ResponseData<Object> res = new ResponseData<>(EnumResponse.ERROR.code());
        res.setMessage(e.getMessage());
        res.setData(null);

        return ResponseEntity.badRequest().body(res);
    }

    /**
     * Maneja excepciones de tipo NoSuchElementException.
     * Se utiliza cuando no se encuentra un recurso solicitado
     *
     * Retorna una respuesta HTTP 404 (Not Found).
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseData<Object>> notFound(NoSuchElementException e) {
        log.warn("NotFound: {}", e.getMessage(), e);

        ResponseData<Object> res = new ResponseData<>(EnumResponse.ERROR.code());
        res.setMessage(e.getMessage());
        res.setData(null);

        return ResponseEntity.status(404).body(res);
    }

    /**
     * Maneja excepciones generales no controladas.
     * Este método actúa como fallback para cualquier error
     * que no haya sido capturado por otros manejadores.
     *
     * Retorna una respuesta HTTP 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseData<Object>> internalError(Exception e) {
        log.error("InternalError:", e);

        ResponseData<Object> res = new ResponseData<>(EnumResponse.ERROR.code());
        res.setMessage("Ocurrió un error interno.");
        res.setData(null);

        return ResponseEntity.status(500).body(res);
    }

     /**
     * Maneja errores cuando no se encuentra un endpoint o recurso.
     * Por ejemplo, cuando la URL no existe en la API.
     *
     * Retorna una respuesta HTTP 404 con un formato simple.
     */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResource(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("code","404","message","Not found"));
    }
}
