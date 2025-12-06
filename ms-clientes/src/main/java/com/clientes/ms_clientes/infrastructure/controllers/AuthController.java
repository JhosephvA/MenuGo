package com.clientes.ms_clientes.infrastructure.controllers;

import com.clientes.ms_clientes.application.ports.in.AutenticarClienteUseCase;
import com.clientes.ms_clientes.application.ports.in.RegistrarClienteUseCase;
import com.clientes.ms_clientes.domain.model.Cliente;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class AuthController {

    private final RegistrarClienteUseCase registrarCliente;
    private final AutenticarClienteUseCase autenticarCliente;

    @PostMapping("/registro")
    public Cliente registrar(@RequestBody Cliente cliente) {
        return registrarCliente.registrar(cliente);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return autenticarCliente.login(request.getEmail(), request.getPassword());
    }
}

@Data
class LoginRequest {
    private String email;
    private String password;
}
