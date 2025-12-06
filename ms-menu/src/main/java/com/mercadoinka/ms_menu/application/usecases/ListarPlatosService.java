package com.mercadoinka.ms_menu.application.usecases;

import com.mercadoinka.ms_menu.application.ports.in.ListarPlatosUseCase;
import com.mercadoinka.ms_menu.application.ports.out.PlatoRepositoryPort;
import com.mercadoinka.ms_menu.domain.model.Plato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPlatosService implements ListarPlatosUseCase {

    private final PlatoRepositoryPort platoRepo;

    @Override
    public List<Plato> listar() {
        return platoRepo.listar();
    }
}
