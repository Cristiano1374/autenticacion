package com.universalHealthcare.usuarios.accesos.service;

import com.universalHealthcare.usuarios.accesos.entity.Usuario;
import com.universalHealthcare.usuarios.accesos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registerUser(Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }
}
