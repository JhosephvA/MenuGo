package com.example.demo.application.usecases;

import com.example.demo.application.ports.in.ListarPedidosUseCase;
import com.example.demo.application.ports.out.PedidoRepositoryPort;
import com.example.demo.domain.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarPedidosService implements ListarPedidosUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public List<Pedido> listar() {
        return pedidoRepositoryPort.listar();
    }
}
