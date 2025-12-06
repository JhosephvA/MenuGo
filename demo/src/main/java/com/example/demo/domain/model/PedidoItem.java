package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItem {

    private Long id;
    private Long platoId;
    private String nombrePlato;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
