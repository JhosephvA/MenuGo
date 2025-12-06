package com.mercadoinka.ms_menu.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

    private Long id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Double precioSoles;
    private String imagenUrl;

}
