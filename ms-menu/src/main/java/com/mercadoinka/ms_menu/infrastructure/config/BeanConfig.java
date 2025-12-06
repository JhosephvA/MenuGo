package com.mercadoinka.ms_menu.infrastructure.config;

import com.mercadoinka.ms_menu.application.ports.in.ConvertirPrecioUseCase;
import com.mercadoinka.ms_menu.application.ports.in.CrearPlatoUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ListarPlatosUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ObtenerCategoriasUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ObtenerImagenUseCase;

import com.mercadoinka.ms_menu.application.ports.out.PlatoRepositoryPort;
import com.mercadoinka.ms_menu.application.ports.out.CategoriaApiPort;
import com.mercadoinka.ms_menu.application.ports.out.ImagenApiPort;
import com.mercadoinka.ms_menu.application.ports.out.MonedaApiPort;

import com.mercadoinka.ms_menu.application.usecases.CrearPlatoService;
import com.mercadoinka.ms_menu.application.usecases.ListarPlatosService;
import com.mercadoinka.ms_menu.application.usecases.ObtenerCategoriasService;
import com.mercadoinka.ms_menu.application.usecases.ObtenerImagenService;
import com.mercadoinka.ms_menu.application.usecases.ConvertirPrecioService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CrearPlatoUseCase crearPlatoUseCase(
            PlatoRepositoryPort repo,
            ImagenApiPort imagenApi,
            CategoriaApiPort categoriaApi) {
        return new CrearPlatoService(repo, imagenApi, categoriaApi);
    }

    @Bean
    public ListarPlatosUseCase listarPlatosUseCase(PlatoRepositoryPort repo) {
        return new ListarPlatosService(repo);
    }

    @Bean
    public ObtenerCategoriasUseCase obtenerCategoriasUseCase(CategoriaApiPort categoriaApi) {
        return new ObtenerCategoriasService(categoriaApi);
    }

    @Bean
    public ObtenerImagenUseCase obtenerImagenUseCase(ImagenApiPort imagenApi) {
        return new ObtenerImagenService(imagenApi);
    }

    @Bean
    public ConvertirPrecioUseCase convertirPrecioUseCase(MonedaApiPort monedaApi) {
        return new ConvertirPrecioService(monedaApi);
    }

}
