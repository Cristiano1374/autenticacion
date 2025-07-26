package com.universal.accesos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pruebas")
@Tag(name = "Pruebas", description = "Endpoints de prueba para Swagger")
public class TestController {

    @GetMapping("/hello")
    @Operation(summary = "Saludo de prueba", description = "Devuelve un mensaje de saludo")
    public String hello() {
        return "Hola, este es un endpoint de prueba";
    }

    @PostMapping("/echo")
    @Operation(summary = "Echo de prueba", description = "Devuelve el mismo mensaje enviado en el cuerpo de la solicitud")
    public String echo(@RequestBody String message) {
        return "Mensaje recibido: " + message;
    }

    @GetMapping("/status")
    @Operation(summary = "Estado de prueba", description = "Devuelve el estado de la aplicación")
    public String status() {
        return "La aplicación está funcionando correctamente";
    }
}