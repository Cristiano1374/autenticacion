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
 * @author Christian Pazmiño
 */
@Embeddable
@Getter
@Setter
public class OpcionPermisosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "opcion_id")
    private Long opcionId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "permiso_id")
    private Long permisoId;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionId != null ? opcionId.hashCode() : 0);
        hash += (permisoId != null ? permisoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPermisosPK)) {
            return false;
        }
        OpcionPermisosPK other = (OpcionPermisosPK) object;
        if (this.opcionId != other.opcionId) {
            return false;
        }
        if (this.permisoId != other.permisoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.OpcionPermisosPK[ opcionId=" + opcionId + ", permisoId=" + permisoId + " ]";
    }
    
}
