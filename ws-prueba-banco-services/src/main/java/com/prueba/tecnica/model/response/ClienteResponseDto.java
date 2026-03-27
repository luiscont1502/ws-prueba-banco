package com.prueba.tecnica.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {
    private Long clienteId;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private Boolean active;
}
