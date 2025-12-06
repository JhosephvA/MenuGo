package com.mercadoinka.ms_menu.infrastructure.controllers;

import com.mercadoinka.ms_menu.application.ports.in.ConvertirPrecioUseCase;
import com.mercadoinka.ms_menu.application.ports.in.CrearPlatoUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ListarPlatosUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ObtenerCategoriasUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ObtenerImagenUseCase;
import com.mercadoinka.ms_menu.application.ports.in.ObtenerPlatoPorIdUseCase;
import com.mercadoinka.ms_menu.domain.model.Plato;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class PlatoController {

    private final CrearPlatoUseCase crearPlatoUseCase;
    private final ListarPlatosUseCase listarPlatosUseCase;
    private final ObtenerCategoriasUseCase obtenerCategoriasUseCase;
    private final ObtenerImagenUseCase obtenerImagenUseCase;
    private final ConvertirPrecioUseCase convertirPrecioUseCase;

    // ⭐ NUEVO: Caso de uso obligatorio para GET /menu/{id}
    private final ObtenerPlatoPorIdUseCase obtenerPlatoPorIdUseCase;

    // Crear plato
    @PostMapping
    public Plato crearPlato(@RequestBody Plato plato) {
        return crearPlatoUseCase.crear(plato);
    }

    // Listar todos los platos
    @GetMapping
    public List<Plato> listarPlatos() {
        return listarPlatosUseCase.listar();
    }

    // Obtener categorías
    @GetMapping("/categorias")
    public List<String> obtenerCategorias() {
        return obtenerCategoriasUseCase.obtenerCategorias();
    }

    // Obtener imagen aleatoria
    @GetMapping("/imagen")
    public String obtenerImagen() {
        return obtenerImagenUseCase.obtenerImagen();
    }

    // Convertir precio
    @GetMapping("/{monto}/convertir")
    public double convertirPrecio(@PathVariable double monto, @RequestParam String moneda) {
        return convertirPrecioUseCase.convertir(monto, moneda);
    }

    // ⭐ NUEVO ENDPOINT que necesita MS-PEDIDOS
    @GetMapping("/{id}")
    public Plato obtenerPlatoPorId(@PathVariable Long id) {
        return obtenerPlatoPorIdUseCase.obtenerPorId(id);
    }
}
