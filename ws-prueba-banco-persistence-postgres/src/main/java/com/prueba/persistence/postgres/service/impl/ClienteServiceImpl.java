package com.prueba.persistence.postgres.service.impl;
import com.prueba.persistence.postgres.entity.ClientesEntity;
import com.prueba.persistence.postgres.repository.ClienteRespository;
import com.prueba.persistence.postgres.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRespository clienteRespository;
    @Override
    public ClientesEntity findByIdentificacion(String identificacion) {
        return clienteRespository.findByIdentificacionAndActiveTrue(identificacion)
                .orElseThrow(() -> new NoSuchElementException("Cliente no encontrado."));
    }
}
