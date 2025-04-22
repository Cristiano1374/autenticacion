/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universalHealthcare.usuarios.accesos.entity;

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
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id"),
    @NamedQuery(name = "Roles.findByNombre", query = "SELECT r FROM Roles r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Roles.findByFechaCreacion", query = "SELECT r FROM Roles r WHERE r.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Roles.findByUsuarioCreacion", query = "SELECT r FROM Roles r WHERE r.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "Roles.findByFechaActualizacion", query = "SELECT r FROM Roles r WHERE r.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Roles.findByUsuarioActualizacion", query = "SELECT r FROM Roles r WHERE r.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "Roles.findByFechaInactivacion", query = "SELECT r FROM Roles r WHERE r.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "Roles.findByUsuarioInactivacion", query = "SELECT r FROM Roles r WHERE r.usuarioInactivacion = :usuarioInactivacion"),
    @NamedQuery(name = "Roles.findByActivo", query = "SELECT r FROM Roles r WHERE r.activo = :activo")})
public class Roles extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UsuarioRoles> usuarioRolesList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<RolPermisos> rolPermisosList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.Roles[ id=" + id + " ]";
    }
}
