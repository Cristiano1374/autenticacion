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
 *
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_rol_permiso", catalog = "accesos", schema = "public")
@NamedQueries({
    @NamedQuery(name = "RolPermisos.findAll", query = "SELECT r FROM RolPermisos r"),
    @NamedQuery(name = "RolPermisos.findByRolId", query = "SELECT r FROM RolPermisos r WHERE r.rolPermisosPK.rolId = :rolId"),
    @NamedQuery(name = "RolPermisos.findByPermisoId", query = "SELECT r FROM RolPermisos r WHERE r.rolPermisosPK.permisoId = :permisoId"),
    @NamedQuery(name = "RolPermisos.findByFechaCreacion", query = "SELECT r FROM RolPermisos r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "RolPermisos.findByUsuarioCreacion", query = "SELECT r FROM RolPermisos r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "RolPermisos.findByFechaActualizacion", query = "SELECT r FROM RolPermisos r WHERE r.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "RolPermisos.findByUsuarioActualizacion", query = "SELECT r FROM RolPermisos r WHERE r.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "RolPermisos.findByFechaInactivacion", query = "SELECT r FROM RolPermisos r WHERE r.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "RolPermisos.findByUsuarioInactivacion", query = "SELECT r FROM RolPermisos r WHERE r.usuarioInactivacion = :usuarioInactivacion"),
    @NamedQuery(name = "RolPermisos.findByActivo", query = "SELECT r FROM RolPermisos r WHERE r.activo = :activo")})
public class RolPermisos extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RolPermisosPK rolPermisosPK;

    @JoinColumn(name = "permiso_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permisos permisos;

    @JoinColumn(name = "rol_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles roles;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolPermisosPK != null ? rolPermisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPermisos)) {
            return false;
        }
        RolPermisos other = (RolPermisos) object;
        if ((this.rolPermisosPK == null && other.rolPermisosPK != null) || (this.rolPermisosPK != null && !this.rolPermisosPK.equals(other.rolPermisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.RolPermisos[ rolPermisosPK=" + rolPermisosPK + " ]";
    }
    
}
