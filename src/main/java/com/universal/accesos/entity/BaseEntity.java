package com.universal.accesos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaCreacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usuario_creacion")
    protected String usuarioCreacion;

    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaActualizacion;

    @Size(min = 1, max = 255)
    @Column(name = "usuario_actualizacion")
    protected String usuarioActualizacion;

    @Column(name = "fecha_inactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaInactivacion;

    @Size(min = 1, max = 255)
    @Column(name = "usuario_inactivacion")
    protected String usuarioInactivacion;

    @Basic(optional = false)
    @Column(name = "activo")
    protected Boolean activo;
}
