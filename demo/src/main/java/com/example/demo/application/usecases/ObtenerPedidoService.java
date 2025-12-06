package com.example.demo.application.usecases;

import com.example.demo.application.ports.in.ObtenerPedidoUseCase;
import com.example.demo.application.ports.out.PedidoRepositoryPort;
import com.example.demo.domain.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObtenerPedidoService implements ObtenerPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public Pedido obtenerPorId(Long id) {
        return pedidoRepositoryPort.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }
}
