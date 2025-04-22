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
 * @author Christian Pazmiño
 */
@Entity
@Getter
@Setter
@Table(name = "acc_menu", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m"),
        @NamedQuery(name = "Menus.findById", query = "SELECT m FROM Menus m WHERE m.id = :id"),
        @NamedQuery(name = "Menus.findByNombre", query = "SELECT m FROM Menus m WHERE m.nombre = :nombre"),
        @NamedQuery(name = "Menus.findByDescripcion", query = "SELECT m FROM Menus m WHERE m.descripcion = :descripcion"),
        @NamedQuery(name = "Menus.findByIcono", query = "SELECT m FROM Menus m WHERE m.icono = :icono"),
        @NamedQuery(name = "Menus.findByOrden", query = "SELECT m FROM Menus m WHERE m.orden = :orden"),
        @NamedQuery(name = "Menus.findByFechaCreacion", query = "SELECT m FROM Menus m WHERE m.fechaCreacion = :fechaCreacion"),
        @NamedQuery(name = "Menus.findByUsuarioCreacion", query = "SELECT m FROM Menus m WHERE m.usuarioCreacion = :usuarioCreacion"),
        @NamedQuery(name = "Menus.findByFechaActualizacion", query = "SELECT m FROM Menus m WHERE m.fechaActualizacion = :fechaActualizacion"),
        @NamedQuery(name = "Menus.findByUsuarioActualizacion", query = "SELECT m FROM Menus m WHERE m.usuarioActualizacion = :usuarioActualizacion"),
        @NamedQuery(name = "Menus.findByFechaInactivacion", query = "SELECT m FROM Menus m WHERE m.fechaInactivacion = :fechaInactivacion"),
        @NamedQuery(name = "Menus.findByUsuarioInactivacion", query = "SELECT m FROM Menus m WHERE m.usuarioInactivacion = :usuarioInactivacion"),
        @NamedQuery(name = "Menus.findByActivo", query = "SELECT m FROM Menus m WHERE m.activo = :activo")})
public class Menus extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSeq")
    @SequenceGenerator(name = "menuSeq", sequenceName = "menus_id_seq", allocationSize = 1, initialValue = 1)
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

    @Size(max = 50)
    @Column(name = "icono")
    private String icono;

    @Column(name = "orden")
    private Integer orden;

    @OneToMany(mappedBy = "menuId", fetch = FetchType.LAZY)
    private List<Opciones> opcionesList;

    @OneToMany(mappedBy = "menuPadre", fetch = FetchType.LAZY)
    private List<Menus> menusList;

    @JoinColumn(name = "menu_padre", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menus menuPadre;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.Menus[ id=" + id + " ]";
    }

}
