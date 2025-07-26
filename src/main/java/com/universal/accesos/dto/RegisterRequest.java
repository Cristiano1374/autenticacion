package com.universal.accesos.dto;

import jakarta.validation.constraints.*;
import java.util.Date;

public record RegisterRequest(

        @NotBlank(message = "El nombre es obligatorio")
        String nombres,

        @NotBlank(message = "El apellido es obligatorio")
        String apellidos,

        @NotBlank(message = "El nombre de usuario es obligatorio")
        String usuario,

        @NotBlank(message = "La clave es obligatoria")
        @Size(min = 6, message = "La clave debe tener al menos 6 caracteres")
        String clave,

        @NotNull(message = "El género es obligatorio")
        String genero,

        @NotBlank(message = "La identificación es obligatoria")
        String identificacion,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        Date fechaNacimiento,

        @NotBlank(message = "La dirección es obligatoria")
        String direccion,

        @NotBlank(message = "El teléfono es obligatorio")
        String telefono,

        @Email(message = "El email debe ser válido")
        @NotBlank(message = "El email es obligatorio")
        String email

) {}
