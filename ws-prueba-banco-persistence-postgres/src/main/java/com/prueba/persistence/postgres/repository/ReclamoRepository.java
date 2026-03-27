package com.prueba.persistence.postgres.repository;

import com.prueba.persistence.postgres.entity.ClientesEntity;
import com.prueba.persistence.postgres.entity.ReclamosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamoRepository extends JpaRepository<ReclamosEntity, Long> {

    List<ReclamosEntity> findByClienteAndActiveTrue(ClientesEntity cliente);

    List<ReclamosEntity> findByClienteClienteIdAndActiveTrue(Long clienteId);
}
