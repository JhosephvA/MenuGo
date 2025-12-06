package com.example.demo.application.ports.in;

import com.example.demo.domain.model.Pedido;

public interface CrearPedidoUseCase {
    Pedido crearPedido(Pedido pedido);
}
