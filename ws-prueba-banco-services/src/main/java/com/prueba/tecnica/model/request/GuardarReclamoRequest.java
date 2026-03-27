package com.prueba.tecnica.model.request;

import lombok.Data;

@Data
public class GuardarReclamoRequest {
    private String identificacion;
    private String tipoReclamo;
    private String detalleReclamo;
}
