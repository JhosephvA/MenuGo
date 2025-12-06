package com.clientes.ms_clientes.infrastructure.adapters;

import com.clientes.ms_clientes.application.ports.out.ClienteRepositoryPort;
import com.clientes.ms_clientes.domain.model.Cliente;
import com.clientes.ms_clientes.infrastructure.persistence.ClienteEntity;
import com.clientes.ms_clientes.infrastructure.persistence.ClienteJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteJpaAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository repo;

    @Override
    public Cliente guardar(Cliente cliente) {

        ClienteEntity entity = new ClienteEntity();
        entity.setNombre(cliente.getNombre());
        entity.setEmail(cliente.getEmail());
        entity.setPassword(cliente.getPassword());

        ClienteEntity saved = repo.save(entity);

        cliente.setId(saved.getId());
        return cliente;
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return repo.findByEmail(email)
                .map(e -> new Cliente(e.getId(), e.getNombre(), e.getEmail(), e.getPassword()));
    }
}
