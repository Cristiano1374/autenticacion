package com.universal.accesos.dto;

import com.universal.accesos.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsuarioAutenticadoDTO implements UserDetails {
    private Usuario usuario;

    /*public UsuarioAutenticado(Usuario usuario) {
        this.usuario = usuario;
    }*/

    public String getNombreCompleto() {
        return usuario.getPersona().getNombreCompleto();
    }

    public String getEmail() {
        return usuario.getPersona().getEmail();
    }

    // Métodos delegados a Usuario
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getAuthorities(); // o personalizar aquí
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return usuario.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuario.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return usuario.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return usuario.isEnabled();
    }
}
