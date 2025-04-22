package com.universalHealthcare.usuarios.accesos.repository;

import com.universalHealthcare.usuarios.accesos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
