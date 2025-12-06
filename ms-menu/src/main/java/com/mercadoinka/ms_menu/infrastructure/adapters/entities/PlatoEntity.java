package com.mercadoinka.ms_menu.infrastructure.adapters.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "platos")
@Data
public class PlatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String categoria;
    private Double precioSoles;
    private String imagenUrl;
}
