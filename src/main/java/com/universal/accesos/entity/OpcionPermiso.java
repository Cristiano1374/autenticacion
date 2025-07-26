/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universal.accesos.entity;

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
        @NamedQuery(name = "OpcionPermiso.findAll", query = "SELECT a FROM OpcionPermiso a")})
public class OpcionPermiso extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OpcionPermisoGen")
    @SequenceGenerator(name = "OpcionPermisoGen", sequenceName = "opcion_permiso_id_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Opcion opcion;

    @JoinColumn(name = "permiso_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permiso permiso;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OpcionPermiso other = (OpcionPermiso) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return "OpcionPermiso{" +
                "id=" + id +
                ", opcion=" + (opcion != null ? opcion.getId() : "null") +
                ", permiso=" + (permiso != null ? permiso.getId() : "null") +
                '}';
    }
}
