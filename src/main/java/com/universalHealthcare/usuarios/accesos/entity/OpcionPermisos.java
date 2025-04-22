/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universalHealthcare.usuarios.accesos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_opcion_permiso", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "OpcionPermisos.findAll", query = "SELECT o FROM OpcionPermisos o"),
        @NamedQuery(name = "OpcionPermisos.findByOpcionId", query = "SELECT o FROM OpcionPermisos o WHERE o.opcionPermisosPK.opcionId = :opcionId"),
        @NamedQuery(name = "OpcionPermisos.findByPermisoId", query = "SELECT o FROM OpcionPermisos o WHERE o.opcionPermisosPK.permisoId = :permisoId"),
        @NamedQuery(name = "OpcionPermisos.findByFechaCreacion", query = "SELECT o FROM OpcionPermisos o WHERE o.fechaCreacion = :fechaCreacion"),
        @NamedQuery(name = "OpcionPermisos.findByUsuarioCreacion", query = "SELECT o FROM OpcionPermisos o WHERE o.usuarioCreacion = :usuarioCreacion"),
        @NamedQuery(name = "OpcionPermisos.findByFechaActualizacion", query = "SELECT o FROM OpcionPermisos o WHERE o.fechaActualizacion = :fechaActualizacion"),
        @NamedQuery(name = "OpcionPermisos.findByUsuarioActualizacion", query = "SELECT o FROM OpcionPermisos o WHERE o.usuarioActualizacion = :usuarioActualizacion"),
        @NamedQuery(name = "OpcionPermisos.findByFechaInactivacion", query = "SELECT o FROM OpcionPermisos o WHERE o.fechaInactivacion = :fechaInactivacion"),
        @NamedQuery(name = "OpcionPermisos.findByUsuarioInactivacion", query = "SELECT o FROM OpcionPermisos o WHERE o.usuarioInactivacion = :usuarioInactivacion"),
        @NamedQuery(name = "OpcionPermisos.findByActivo", query = "SELECT o FROM OpcionPermisos o WHERE o.activo = :activo")})
public class OpcionPermisos extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected OpcionPermisosPK opcionPermisosPK;

    @JoinColumn(name = "opcion_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Opciones opciones;

    @JoinColumn(name = "permiso_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permisos permisos;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionPermisosPK != null ? opcionPermisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPermisos)) {
            return false;
        }
        OpcionPermisos other = (OpcionPermisos) object;
        if ((this.opcionPermisosPK == null && other.opcionPermisosPK != null) || (this.opcionPermisosPK != null && !this.opcionPermisosPK.equals(other.opcionPermisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OpcionPermisos{" +
                "opcionPermisosPK=" + opcionPermisosPK +
                ", opciones=" + opciones +
                ", permisos=" + permisos +
                '}';
    }

}
