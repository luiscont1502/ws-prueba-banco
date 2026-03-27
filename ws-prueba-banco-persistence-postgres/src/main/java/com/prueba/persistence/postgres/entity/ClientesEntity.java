package com.prueba.persistence.postgres.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes", schema = "public", catalog = "prueba_banco")
public class ClientesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cliente_id")
    private long clienteId;
    @Basic
    @Column(name = "identificacion")
    private String identificacion;
    @Basic
    @Column(name = "nombres")
    private String nombres;
    @Basic
    @Column(name = "apellidos")
    private String apellidos;
    @Basic
    @Column(name = "active")
    private boolean active;
    @Basic
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @Basic
    @Column(name = "modification_date")
    private Timestamp modificationDate;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<ReclamosEntity> reclamos;
}
