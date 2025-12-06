package com.example.demo.application.usecases;

import com.example.demo.application.ports.in.CrearPedidoUseCase;
import com.example.demo.application.ports.out.MenuApiPort;
import com.example.demo.application.ports.out.MonedaApiPort;
import com.example.demo.application.ports.out.PedidoRepositoryPort;
import com.example.demo.domain.model.EstadoPedido;
import com.example.demo.domain.model.Pedido;
import com.example.demo.domain.model.PedidoItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CrearPedidoService implements CrearPedidoUseCase {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final MenuApiPort menuApiPort;
    private final MonedaApiPort monedaApiPort;

    @Override
    public Pedido crearPedido(Pedido pedido) {

        // 1. Fecha y estado inicial
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado(EstadoPedido.PENDIENTE);

        double totalSoles = 0.0;

        // 2. Procesar cada item del pedido
        for (PedidoItem item : pedido.getItems()) {

            // Obtener datos del plato desde MS-MENU
            var plato = menuApiPort.obtenerPlatoPorId(item.getPlatoId());

            // Completar datos del item
            item.setNombrePlato(plato.nombre);
            item.setPrecioUnitario(plato.precioSoles);

            double subtotal = plato.precioSoles * item.getCantidad();
            item.setSubtotal(subtotal);

            totalSoles += subtotal;
        }

        // 3. Guardar total en soles
        pedido.setTotalSoles(totalSoles);

        // 4. Conversión de moneda si el pedido no es en PEN
        String monedaDestino = pedido.getMoneda();
        if (monedaDestino == null || monedaDestino.isBlank()) {
            monedaDestino = "PEN";
            pedido.setMoneda("PEN");
        }

        double totalFinal;
        if ("PEN".equalsIgnoreCase(monedaDestino)) {
            totalFinal = totalSoles;
        } else {
            totalFinal = monedaApiPort.convertir(totalSoles, monedaDestino);
        }

        pedido.setTotal(totalFinal);

        // 5. Guardar pedido final
        return pedidoRepositoryPort.guardar(pedido);
    }
}
