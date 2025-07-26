package com.universal.accesos.service;

import com.universal.accesos.entity.Persona;
import com.universal.accesos.entity.Rol;
import com.universal.accesos.entity.Usuario;
import com.universal.accesos.entity.UsuarioRol;
import com.universal.accesos.repository.UsuarioRepository;
import com.universal.accesos.repository.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    public String registerUser(Usuario usuario) {
        Persona persona = new Persona();
        //persona.setApellidos(usuario.);
        //persona.setNombreCompleto();
        //persona.setNombres();
        usuarioRepository.save(usuario);
        Rol rol = new Rol();
        rol.setId(1L);
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioRolRepository.save(usuarioRol);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}
