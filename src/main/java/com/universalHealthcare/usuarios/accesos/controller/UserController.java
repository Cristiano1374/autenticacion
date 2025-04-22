package com.universalHealthcare.usuarios.accesos.controller;

import com.universalHealthcare.usuarios.accesos.entity.Usuario;
import com.universalHealthcare.usuarios.accesos.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "users", description = "Users management")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Usuario registerUser(@RequestBody Usuario usuario) {
        return userService.registerUser(usuario);
    }
}
