package com.clientes.ms_clientes.application.ports.in;

public interface AutenticarClienteUseCase {
    String login(String email, String password);
}
