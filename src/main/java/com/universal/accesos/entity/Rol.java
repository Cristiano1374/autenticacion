/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universal.accesos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_rol", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Rol.findAll", query = "SELECT a FROM Rol a")})
public class Rol extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RolGen")
    @SequenceGenerator(name = "RolGen", sequenceName = "rol_id_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<UsuarioRol> usuarioRolList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    private List<RolPermiso> rolPermisosList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "om.universal.accesos.entity.Rol[ id=" + id + " ]";
    }
}
