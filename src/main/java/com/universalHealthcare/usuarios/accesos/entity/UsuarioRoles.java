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
@Table(name = "acc_usuario_rol", catalog = "accesos", schema = "public")
@NamedQueries({
    @NamedQuery(name = "UsuarioRoles.findAll", query = "SELECT u FROM UsuarioRoles u"),
    @NamedQuery(name = "UsuarioRoles.findByUsuarioId", query = "SELECT u FROM UsuarioRoles u WHERE u.usuarioRolesPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "UsuarioRoles.findByRolId", query = "SELECT u FROM UsuarioRoles u WHERE u.usuarioRolesPK.rolId = :rolId"),
    @NamedQuery(name = "UsuarioRoles.findByFechaCreacion", query = "SELECT u FROM UsuarioRoles u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "UsuarioRoles.findByUsuarioCreacion", query = "SELECT u FROM UsuarioRoles u WHERE u.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "UsuarioRoles.findByFechaActualizacion", query = "SELECT u FROM UsuarioRoles u WHERE u.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "UsuarioRoles.findByUsuarioActualizacion", query = "SELECT u FROM UsuarioRoles u WHERE u.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "UsuarioRoles.findByFechaInactivacion", query = "SELECT u FROM UsuarioRoles u WHERE u.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "UsuarioRoles.findByUsuarioInactivacion", query = "SELECT u FROM UsuarioRoles u WHERE u.usuarioInactivacion = :usuarioInactivacion"),
    @NamedQuery(name = "UsuarioRoles.findByActivo", query = "SELECT u FROM UsuarioRoles u WHERE u.activo = :activo")})
public class UsuarioRoles extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected UsuarioRolesPK usuarioRolesPK;

    @JoinColumn(name = "rol_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Roles roles;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioRolesPK != null ? usuarioRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRoles)) {
            return false;
        }
        UsuarioRoles other = (UsuarioRoles) object;
        if ((this.usuarioRolesPK == null && other.usuarioRolesPK != null) || (this.usuarioRolesPK != null && !this.usuarioRolesPK.equals(other.usuarioRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.UsuarioRoles[ usuarioRolesPK=" + usuarioRolesPK + " ]";
    }
    
}
