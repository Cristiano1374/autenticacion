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
@Table(name = "acc_permiso", catalog = "accesos", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"),
    @NamedQuery(name = "Permisos.findById", query = "SELECT p FROM Permisos p WHERE p.id = :id"),
    @NamedQuery(name = "Permisos.findByNombre", query = "SELECT p FROM Permisos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Permisos.findByDescripcion", query = "SELECT p FROM Permisos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Permisos.findByFechaCreacion", query = "SELECT p FROM Permisos p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Permisos.findByUsuarioCreacion", query = "SELECT p FROM Permisos p WHERE p.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "Permisos.findByFechaActualizacion", query = "SELECT p FROM Permisos p WHERE p.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Permisos.findByUsuarioActualizacion", query = "SELECT p FROM Permisos p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
    @NamedQuery(name = "Permisos.findByFechaInactivacion", query = "SELECT p FROM Permisos p WHERE p.fechaInactivacion = :fechaInactivacion"),
    @NamedQuery(name = "Permisos.findByUsuarioInactivacion", query = "SELECT p FROM Permisos p WHERE p.usuarioInactivacion = :usuarioInactivacion"),
    @NamedQuery(name = "Permisos.findByActivo", query = "SELECT p FROM Permisos p WHERE p.activo = :activo")})
public class Permisos extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisos", fetch = FetchType.LAZY)
    private List<OpcionPermisos> opcionPermisosList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisos", fetch = FetchType.LAZY)
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
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.Permisos[ id=" + id + " ]";
    }

}
