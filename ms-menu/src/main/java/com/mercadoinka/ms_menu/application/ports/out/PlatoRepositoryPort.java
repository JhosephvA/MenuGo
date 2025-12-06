package com.mercadoinka.ms_menu.application.ports.out;

import com.mercadoinka.ms_menu.domain.model.Plato;
import java.util.List;
import java.util.Optional;

public interface PlatoRepositoryPort {

    Plato guardar(Plato plato);

    List<Plato> listar();

    Optional<Plato> buscarPorId(Long id);

}
