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
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author cpazmino
 */
@Entity
@Getter
@Setter
@Table(name = "acc_usuario", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuario u"),
        @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
        @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
        @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
        @NamedQuery(name = "Usuarios.findByPersonaId", query = "SELECT u FROM Usuario u WHERE u.personaId = :personaId"),
        @NamedQuery(name = "Usuarios.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
        @NamedQuery(name = "Usuarios.findByUsuarioCreacion", query = "SELECT u FROM Usuario u WHERE u.usuarioCreacion = :usuarioCreacion"),
        @NamedQuery(name = "Usuarios.findByFechaActualizacion", query = "SELECT u FROM Usuario u WHERE u.fechaActualizacion = :fechaActualizacion"),
        @NamedQuery(name = "Usuarios.findByUsuarioActualizacion", query = "SELECT u FROM Usuario u WHERE u.usuarioActualizacion = :usuarioActualizacion"),
        @NamedQuery(name = "Usuarios.findByFechaInactivacion", query = "SELECT u FROM Usuario u WHERE u.fechaInactivacion = :fechaInactivacion"),
        @NamedQuery(name = "Usuarios.findByUsuarioInactivacion", query = "SELECT u FROM Usuario u WHERE u.usuarioInactivacion = :usuarioInactivacion"),
        @NamedQuery(name = "Usuarios.findByActivo", query = "SELECT u FROM Usuario u WHERE u.activo = :activo")})
public class Usuario extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "clave")
    private String clave;

    @Column(name = "persona_id")
    private Long personaId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<UsuarioRoles> usuarioRolesList;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Usuario usuario = (Usuario) o;
        return getId() != null && Objects.equals(getId(), usuario.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.Usuarios[ id=" + id + " ]";
    }
}
