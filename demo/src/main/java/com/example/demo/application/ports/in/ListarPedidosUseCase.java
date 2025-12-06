package com.example.demo.application.ports.in;

import com.example.demo.domain.model.Pedido;
import java.util.List;

public interface ListarPedidosUseCase {
    List<Pedido> listar();
}
