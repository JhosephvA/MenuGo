package com.mercadoinka.ms_menu.application.usecases;

import com.mercadoinka.ms_menu.application.ports.in.ObtenerPlatoPorIdUseCase;
import com.mercadoinka.ms_menu.application.ports.out.PlatoRepositoryPort;
import com.mercadoinka.ms_menu.domain.model.Plato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerPlatoPorIdService implements ObtenerPlatoPorIdUseCase {

    private final PlatoRepositoryPort platoRepositoryPort;

    @Override
    public Plato obtenerPorId(Long id) {
        return platoRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado: " + id));
    }
}
