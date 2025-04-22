/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universalHealthcare.usuarios.accesos.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author sierv
 */
@Embeddable
@Setter
@Getter
public class UsuarioRolesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_id")
    private Long rolId;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRolesPK)) {
            return false;
        }
        UsuarioRolesPK other = (UsuarioRolesPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.rolId != other.rolId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.UsuarioRolesPK[ usuarioId=" + usuarioId + ", rolId=" + rolId + " ]";
    }
    
}
