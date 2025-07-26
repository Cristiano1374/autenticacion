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

/**
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_opcion", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Opcion.findAll", query = "SELECT a FROM Opcion a")})
public class Opcion extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OpcionGen")
    @SequenceGenerator(name = "OpcionGen", sequenceName = "opcion_id_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Size(max = 255)
    @Column(name = "url", length = 255)
    private String url;

    @Size(max = 50)
    @Column(name = "icono", length = 50)
    private String icono;

    @Column(name = "orden")
    private Integer orden;

    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.accesos.entity.Opcion[ id=" + id + " ]";
    }

}
