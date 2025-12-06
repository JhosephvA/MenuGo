package com.clientes.ms_clientes.application.ports.in;

import com.clientes.ms_clientes.domain.model.Cliente;

public interface RegistrarClienteUseCase {
    Cliente registrar(Cliente cliente);
}
