package com.prueba.tecnica.controller;

import com.prueba.persistence.postgres.entity.ReclamosEntity;
import com.prueba.tecnica.core.ClienteCore;
import com.prueba.tecnica.core.ReclamoCore;
import com.prueba.tecnica.model.ResponseData;
import com.prueba.tecnica.model.request.GuardarReclamoRequest;
import com.prueba.tecnica.model.response.ClienteResponseDto;
import com.prueba.tecnica.model.response.ReclamoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reclamos")
@RequiredArgsConstructor
public class ReclamoController {
    private final ClienteCore clienteCore;

    private final ReclamoCore reclamoCore;

    /**
     * Metodo para consultar el cliente
     * **/
    @GetMapping("/cliente/{identificacion}")
    public ResponseEntity<ResponseData<ClienteResponseDto>> consultarCliente(@PathVariable String identificacion) {
        var data = clienteCore.consultarCliente(identificacion);
        return ResponseEntity.ok(ResponseData.ok(data));
    }

    /**
     * Metodo para guardar los reclamos del cliente
     * **/
    @PostMapping
    public ResponseEntity<ResponseData<ReclamoResponseDto>> guardarReclamo(@RequestBody GuardarReclamoRequest request) {
        var data = reclamoCore.guardarReclamo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseData.ok(data));
    }
}
