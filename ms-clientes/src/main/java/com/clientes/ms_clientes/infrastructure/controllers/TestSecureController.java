package com.clientes.ms_clientes.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecureController {

    @GetMapping("/secure/test")
    public String test() {
        return "Acceso permitido con JWT";
    }
}
