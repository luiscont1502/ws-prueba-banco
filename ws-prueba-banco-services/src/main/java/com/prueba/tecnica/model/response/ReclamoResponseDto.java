package com.prueba.tecnica.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReclamoResponseDto {
    private Long reclamoId;
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String tipoReclamo;
    private String detalleReclamo;
    private Boolean active;
}
