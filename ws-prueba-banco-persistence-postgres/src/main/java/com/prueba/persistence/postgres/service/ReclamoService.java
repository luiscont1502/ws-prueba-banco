package com.prueba.persistence.postgres.service;

import com.prueba.persistence.postgres.entity.ReclamosEntity;

public interface ReclamoService {

    ReclamosEntity guardar(ReclamosEntity reclamo);
}
