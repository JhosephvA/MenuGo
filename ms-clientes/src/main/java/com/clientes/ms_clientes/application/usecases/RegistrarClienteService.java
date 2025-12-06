package com.clientes.ms_clientes.application.usecases;

import com.clientes.ms_clientes.application.ports.in.RegistrarClienteUseCase;
import com.clientes.ms_clientes.application.ports.out.ClienteRepositoryPort;
import com.clientes.ms_clientes.domain.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrarClienteService implements RegistrarClienteUseCase {

    private final ClienteRepositoryPort repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Cliente registrar(Cliente cliente) {

        // Encriptar contraseña
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));

        return repo.guardar(cliente);
    }
}
