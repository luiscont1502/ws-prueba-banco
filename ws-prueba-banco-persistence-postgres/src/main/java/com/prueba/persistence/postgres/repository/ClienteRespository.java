package com.prueba.persistence.postgres.repository;

import com.prueba.persistence.postgres.entity.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRespository extends JpaRepository<ClientesEntity, Long> {

    Optional<ClientesEntity> findByIdentificacion(String identificacion);

    Optional<ClientesEntity> findByIdentificacionAndActiveTrue(String identificacion);
}
