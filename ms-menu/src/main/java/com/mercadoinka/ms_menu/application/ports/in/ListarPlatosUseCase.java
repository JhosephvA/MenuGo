package com.mercadoinka.ms_menu.application.ports.in;

import com.mercadoinka.ms_menu.domain.model.Plato;
import java.util.List;

public interface ListarPlatosUseCase {
    List<Plato> listar();
}
