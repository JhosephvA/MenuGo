package com.mercadoinka.ms_menu.application.usecases;

import com.mercadoinka.ms_menu.application.ports.in.CrearPlatoUseCase;
import com.mercadoinka.ms_menu.application.ports.out.CategoriaApiPort;
import com.mercadoinka.ms_menu.application.ports.out.ImagenApiPort;
import com.mercadoinka.ms_menu.application.ports.out.PlatoRepositoryPort;
import com.mercadoinka.ms_menu.domain.model.Plato;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CrearPlatoService implements CrearPlatoUseCase {

    private final PlatoRepositoryPort platoRepo;
    private final ImagenApiPort imagenApi;
    private final CategoriaApiPort categoriaApi;

    @Override
    public Plato crear(Plato plato) {

        // Obtener imagen aleatoria desde API
        String imagen = imagenApi.obtenerImagenAleatoria();
        plato.setImagenUrl(imagen);

        // Obtener categoría desde API si no se envió una
        if (plato.getCategoria() == null || plato.getCategoria().isBlank()) {
            List<String> categorias = categoriaApi.obtenerCategorias();
            plato.setCategoria(categorias.get(0)); // Primera categoría
        }

        return platoRepo.guardar(plato);
    }
}
