package com.prueba.persistence.postgres.service;

import com.prueba.persistence.postgres.entity.ClientesEntity;

public interface ClienteService {
    ClientesEntity findByIdentificacion(String identificacion);
}
