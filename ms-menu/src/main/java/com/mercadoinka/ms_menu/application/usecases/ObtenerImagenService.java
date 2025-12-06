package com.mercadoinka.ms_menu.application.usecases;

import com.mercadoinka.ms_menu.application.ports.in.ObtenerImagenUseCase;
import com.mercadoinka.ms_menu.application.ports.out.ImagenApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerImagenService implements ObtenerImagenUseCase {

    private final ImagenApiPort imagenApi;

    @Override
    public String obtenerImagen() {
        return imagenApi.obtenerImagenAleatoria();
    }
}
