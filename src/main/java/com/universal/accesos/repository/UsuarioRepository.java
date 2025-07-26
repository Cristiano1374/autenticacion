package com.universal.accesos.repository;

import com.universal.accesos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(name = "Usuario.findByUsuario")
    Optional<Usuario> findByUsuario(@Param("usuario") String usuario);
}
