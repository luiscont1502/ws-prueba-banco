package com.prueba.tecnica.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConsultarClienteResponse {
    private String nombre;
    private String apellido;
}
