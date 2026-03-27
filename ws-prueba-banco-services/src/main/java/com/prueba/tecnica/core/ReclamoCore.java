package com.prueba.tecnica.core;

import com.prueba.persistence.postgres.entity.ClientesEntity;
import com.prueba.persistence.postgres.entity.ReclamosEntity;
import com.prueba.persistence.postgres.service.ClienteService;
import com.prueba.persistence.postgres.service.ReclamoService;
import com.prueba.tecnica.model.request.GuardarReclamoRequest;
import com.prueba.tecnica.model.response.ReclamoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReclamoCore {

    private final ClienteService clienteService;

    private final ReclamoService reclamoService;

    public ReclamoResponseDto guardarReclamo(GuardarReclamoRequest reclamoRequest) {

        ClientesEntity cliente = clienteService.findByIdentificacion(reclamoRequest.getIdentificacion());

        ReclamosEntity reclamo = new ReclamosEntity();
        reclamo.setCliente(cliente);
        reclamo.setTipoReclamo(reclamoRequest.getTipoReclamo());
        reclamo.setDetalleReclamo(reclamoRequest.getDetalleReclamo());
        reclamo.setActive(true);

        ReclamosEntity guardado = reclamoService.guardar(reclamo);

        ReclamoResponseDto response = new ReclamoResponseDto();
        response.setReclamoId(guardado.getReclamoId());
        response.setIdentificacion(guardado.getCliente().getIdentificacion());
        response.setNombres(guardado.getCliente().getNombres());
        response.setApellidos(guardado.getCliente().getApellidos());
        response.setTipoReclamo(guardado.getTipoReclamo());
        response.setDetalleReclamo(guardado.getDetalleReclamo());
        response.setActive(guardado.isActive());

        return response;
    }


}
