package com.mercadoinka.ms_menu.application.usecases;

import com.mercadoinka.ms_menu.application.ports.in.ObtenerCategoriasUseCase;
import com.mercadoinka.ms_menu.application.ports.out.CategoriaApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerCategoriasService implements ObtenerCategoriasUseCase {

    private final CategoriaApiPort categoriaApi;

    @Override
    public List<String> obtenerCategorias() {
        return categoriaApi.obtenerCategorias();
    }
}
