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
 *
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_rol_permiso", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "RolPermiso.findAll", query = "SELECT a FROM RolPermiso a")})
public class RolPermiso extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RolPermisoGen")
    @SequenceGenerator(name = "RolPermisoGen", sequenceName = "rol_permiso_id_seq", allocationSize = 1, initialValue = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permiso_id", nullable = false)
    private Permiso permiso;

    

}
