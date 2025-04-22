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
import java.util.Date;

/**
 * @author sierv
 */
@Entity
@Getter
@Setter
@Table(name = "acc_persona", catalog = "accesos", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Persona p"),
        @NamedQuery(name = "Personas.findById", query = "SELECT p FROM Persona p WHERE p.id = :id"),
        @NamedQuery(name = "Personas.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres"),
        @NamedQuery(name = "Personas.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos"),
        @NamedQuery(name = "Personas.findByNombreCompleto", query = "SELECT p FROM Persona p WHERE p.nombreCompleto = :nombreCompleto"),
        @NamedQuery(name = "Personas.findByGenero", query = "SELECT p FROM Persona p WHERE p.genero = :genero"),
        @NamedQuery(name = "Personas.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion"),
        @NamedQuery(name = "Personas.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
        @NamedQuery(name = "Personas.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
        @NamedQuery(name = "Personas.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
        @NamedQuery(name = "Personas.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
        @NamedQuery(name = "Personas.findByFechaCreacion", query = "SELECT p FROM Persona p WHERE p.fechaCreacion = :fechaCreacion"),
        @NamedQuery(name = "Personas.findByUsuarioCreacion", query = "SELECT p FROM Persona p WHERE p.usuarioCreacion = :usuarioCreacion"),
        @NamedQuery(name = "Personas.findByFechaActualizacion", query = "SELECT p FROM Persona p WHERE p.fechaActualizacion = :fechaActualizacion"),
        @NamedQuery(name = "Personas.findByUsuarioActualizacion", query = "SELECT p FROM Persona p WHERE p.usuarioActualizacion = :usuarioActualizacion"),
        @NamedQuery(name = "Personas.findByFechaInactivacion", query = "SELECT p FROM Persona p WHERE p.fechaInactivacion = :fechaInactivacion"),
        @NamedQuery(name = "Personas.findByUsuarioInactivacion", query = "SELECT p FROM Persona p WHERE p.usuarioInactivacion = :usuarioInactivacion"),
        @NamedQuery(name = "Personas.findByActivo", query = "SELECT p FROM Persona p WHERE p.activo = :activo")})
public class Persona extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private Character genero;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Size(max = 2147483647)
    @Column(name = "direccion")
    private String direccion;

    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.universal.authentication.accesos.entity.Personas[ id=" + id + " ]";
    }

}
