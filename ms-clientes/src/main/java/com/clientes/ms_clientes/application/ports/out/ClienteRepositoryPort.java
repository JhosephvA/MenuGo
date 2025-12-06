package com.clientes.ms_clientes.application.ports.out;

import com.clientes.ms_clientes.domain.model.Cliente;
import java.util.Optional;

public interface ClienteRepositoryPort {

    Cliente guardar(Cliente cliente);

    Optional<Cliente> buscarPorEmail(String email);
}
