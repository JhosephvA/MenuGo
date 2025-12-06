package com.example.demo.infrastructure.web;

import com.example.demo.application.ports.in.CrearPedidoUseCase;
import com.example.demo.application.ports.in.ListarPedidosUseCase;
import com.example.demo.application.ports.in.ObtenerPedidoUseCase;
import com.example.demo.domain.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final CrearPedidoUseCase crearPedidoUseCase;
    private final ListarPedidosUseCase listarPedidosUseCase;
    private final ObtenerPedidoUseCase obtenerPedidoUseCase;

    // Crear pedido
    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return crearPedidoUseCase.crearPedido(pedido);
    }

    // Listar pedidos
    @GetMapping
    public List<Pedido> listar() {
        return listarPedidosUseCase.listar();
    }

    // Obtener pedido por ID
    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id) {
        return obtenerPedidoUseCase.obtenerPorId(id);
    }
}
