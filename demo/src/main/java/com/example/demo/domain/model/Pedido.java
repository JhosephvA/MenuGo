package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Long id;
    private LocalDateTime fecha;

    // Estado ahora es un ENUM, NO un String
    private EstadoPedido estado;

    private String moneda;
    private Double total;
    private Double totalSoles;

    private List<PedidoItem> items;

    private String emailCliente;

}
