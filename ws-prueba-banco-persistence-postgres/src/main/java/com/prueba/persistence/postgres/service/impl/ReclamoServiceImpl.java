package com.prueba.persistence.postgres.service.impl;

import com.prueba.persistence.postgres.entity.ReclamosEntity;
import com.prueba.persistence.postgres.repository.ReclamoRepository;
import com.prueba.persistence.postgres.service.ReclamoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
@RequiredArgsConstructor
public class ReclamoServiceImpl implements ReclamoService {

    private final ReclamoRepository reclamoRepository;

    @Override
    public ReclamosEntity guardar(ReclamosEntity reclamo) {
        try {
            return reclamoRepository.save(reclamo);
        }catch(Exception e){
            log.info("Error en guardar() : {}",e.getMessage());
            throw new IllegalArgumentException("No se pudo guardar el reclamo.");
        }

    }
}
