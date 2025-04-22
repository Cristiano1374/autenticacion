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
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_opcion", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
        @NamedQuery(name = "Opciones.findById", query = "SELECT o FROM Opciones o WHERE o.id = :id"),
        @NamedQuery(name = "Opciones.findByNombre", query = "SELECT o FROM Opciones o WHERE o.nombre = :nombre"),
        @NamedQuery(name = "Opciones.findByDescripcion", query = "SELECT o FROM Opciones o WHERE o.descripcion = :descripcion"),
        @NamedQuery(name = "Opciones.findByUrl", query = "SELECT o FROM Opciones o WHERE o.url = :url"),
        @NamedQuery(name = "Opciones.findByIcono", query = "SELECT o FROM Opciones o WHERE o.icono = :icono"),
        @NamedQuery(name = "Opciones.findByFechaCreacion", query = "SELECT o FROM Opciones o WHERE o.fechaCreacion = :fechaCreacion"),
        @NamedQuery(name = "Opciones.findByUsuarioCreacion", query = "SELECT o FROM Opciones o WHERE o.usuarioCreacion = :usuarioCreacion"),
        @NamedQuery(name = "Opciones.findByFechaActualizacion", query = "SELECT o FROM Opciones o WHERE o.fechaActualizacion = :fechaActualizacion"),
        @NamedQuery(name = "Opciones.findByUsuarioActualizacion", query = "SELECT o FROM Opciones o WHERE o.usuarioActualizacion = :usuarioActualizacion"),
        @NamedQuery(name = "Opciones.findByFechaInactivacion", query = "SELECT o FROM Opciones o WHERE o.fechaInactivacion = :fechaInactivacion"),
        @NamedQuery(name = "Opciones.findByUsuarioInactivacion", query = "SELECT o FROM Opciones o WHERE o.usuarioInactivacion = :usuarioInactivacion"),
        @NamedQuery(name = "Opciones.findByActivo", query = "SELECT o FROM Opciones o WHERE o.activo = :activo")})
public class Opciones extends BaseEntity implements Serializable {

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

    @Size(max = 255)
    @Column(name = "url")
    private String url;

    @Size(max = 50)
    @Column(name = "icono")
    private String icono;

    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menus menuId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opciones", fetch = FetchType.LAZY)
    private List<OpcionPermisos> opcionPermisosList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.Opciones[ id=" + id + " ]";
    }

}
