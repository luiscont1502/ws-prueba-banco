package com.prueba.tecnica.core;

import com.prueba.persistence.postgres.entity.ClientesEntity;
import com.prueba.persistence.postgres.service.ClienteService;
import com.prueba.tecnica.model.response.ClienteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteCore {

    private final ClienteService clienteService;
    public ClienteResponseDto consultarCliente(String identificacion){
        ClientesEntity cliente = clienteService.findByIdentificacion(identificacion);

        ClienteResponseDto dto = new ClienteResponseDto(
                cliente.getClienteId(),
                cliente.getIdentificacion(),
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.isActive()
        );
        return dto;
    }
}
