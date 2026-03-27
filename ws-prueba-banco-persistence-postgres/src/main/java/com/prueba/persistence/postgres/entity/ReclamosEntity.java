package com.prueba.persistence.postgres.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reclamos", schema = "public", catalog = "prueba_banco")
public class ReclamosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reclamo_id")
    private long reclamoId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClientesEntity cliente;
    @Basic
    @Column(name = "tipo_reclamo")
    private String tipoReclamo;
    @Basic
    @Column(name = "detalle_reclamo")
    private String detalleReclamo;
    @Basic
    @Column(name = "active")
    private boolean active;
    @Basic
    @Column(name = "creation_date", insertable = false, updatable = false)
    private Timestamp creationDate;
    @Basic
    @Column(name = "modification_date" , insertable = false, updatable = false)
    private Timestamp modificationDate;

}
