package com.universal.accesos.service;

import com.universal.accesos.config.JwtService;
import com.universal.accesos.dto.RegisterRequest;
import com.universal.accesos.dto.TokenResponse;
import com.universal.accesos.entity.Persona;
import com.universal.accesos.entity.Usuario;
import com.universal.accesos.repository.PersonaRepository;
import com.universal.accesos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public TokenResponse register(RegisterRequest registerRequest) {
        if (usuarioRepository.findByUsuario(registerRequest.usuario()).isPresent()) {
            throw new IllegalArgumentException("El usuario ya existe");
        }

        Persona persona = crearPersonaDesdeRequest(registerRequest);
        personaRepository.save(persona);

        Usuario usuario = crearUsuarioDesdeRequest(registerRequest, persona);
        Usuario savedUser = usuarioRepository.save(usuario);

        String accessToken = jwtService.generateToken(savedUser);
        String refreshToken = jwtService.generateRefreshToken(savedUser);

        return new TokenResponse(accessToken, refreshToken);
    }

    public String generateAccessToken(UserDetails userDetails) {
        return jwtService.generateToken(userDetails);
    }

    public TokenResponse refreshToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Token no válido");
        }

        String refreshToken = authHeader.substring(7);
        String username = jwtService.extractUsername(refreshToken);

        UserDetails userDetails = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!jwtService.isTokenValid(refreshToken, userDetails)) {
            throw new IllegalArgumentException("Token expirado o inválido");
        }

        String newAccessToken = jwtService.generateToken(userDetails);
        return new TokenResponse(newAccessToken, refreshToken);
    }

    private Persona crearPersonaDesdeRequest(RegisterRequest request) {
        Persona persona = new Persona();
        persona.setNombres(request.nombres());
        persona.setApellidos(request.apellidos());
        persona.setNombreCompleto(request.nombres() + " " + request.apellidos());
        persona.setGenero(request.genero().toUpperCase().charAt(0));
        persona.setIdentificacion(request.identificacion());
        persona.setFechaNacimiento(request.fechaNacimiento());
        persona.setDireccion(request.direccion());
        persona.setTelefono(request.telefono());
        persona.setEmail(request.email());
        persona.setActivo(true);
        persona.setFechaCreacion(new java.util.Date());
        persona.setUsuarioCreacion("system");
        return persona;
    }

    private Usuario crearUsuarioDesdeRequest(RegisterRequest request, Persona persona) {
        Usuario usuario = new Usuario();
        usuario.setUsuario(request.usuario());
        usuario.setClave(passwordEncoder.encode(request.clave()));
        usuario.setPersona(persona);
        usuario.setActivo(true);
        usuario.setFechaCreacion(new java.util.Date());
        usuario.setUsuarioCreacion("system");
        return usuario;
    }

    public TokenResponse login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getClave())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        String accessToken = jwtService.generateToken(usuario);
        String refreshToken = jwtService.generateRefreshToken(usuario);

        return new TokenResponse(accessToken, refreshToken);
    }

}
