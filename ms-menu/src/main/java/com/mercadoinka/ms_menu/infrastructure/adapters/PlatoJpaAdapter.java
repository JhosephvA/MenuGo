package com.mercadoinka.ms_menu.infrastructure.adapters;

import com.mercadoinka.ms_menu.application.ports.out.PlatoRepositoryPort;
import com.mercadoinka.ms_menu.domain.model.Plato;
import com.mercadoinka.ms_menu.infrastructure.adapters.entities.PlatoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional; // ✔ IMPORTANTE

@Component
@RequiredArgsConstructor
public class PlatoJpaAdapter implements PlatoRepositoryPort {

    private final PlatoJpaRepository repo;

    @Override
    public Plato guardar(Plato plato) {
        PlatoEntity entity = new PlatoEntity();
        entity.setNombre(plato.getNombre());
        entity.setDescripcion(plato.getDescripcion());
        entity.setCategoria(plato.getCategoria());
        entity.setPrecioSoles(plato.getPrecioSoles());
        entity.setImagenUrl(plato.getImagenUrl());

        PlatoEntity saved = repo.save(entity);

        plato.setId(saved.getId());
        return plato;
    }

    @Override
    public List<Plato> listar() {
        return repo.findAll().stream()
                .map(e -> new Plato(
                        e.getId(),
                        e.getNombre(),
                        e.getDescripcion(),
                        e.getCategoria(),
                        e.getPrecioSoles(),
                        e.getImagenUrl()))
                .toList();
    }

    @Override
    public Optional<Plato> buscarPorId(Long id) {

        return repo.findById(id)
                .map(e -> new Plato(
                        e.getId(),
                        e.getNombre(),
                        e.getDescripcion(),
                        e.getCategoria(),
                        e.getPrecioSoles(),
                        e.getImagenUrl()));
    }
}
