package com.universal.accesos.controller;

import com.universal.accesos.entity.Usuario;
import com.universal.accesos.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "users", description = "Users management")
public class UserController {

    /*@Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Usuario usuario) {
        String resultado = userService.registerUser(usuario);
        return "usuario creado";
    }*/
}
