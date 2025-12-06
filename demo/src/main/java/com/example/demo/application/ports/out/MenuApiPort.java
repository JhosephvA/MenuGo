package com.example.demo.application.ports.out;

public interface MenuApiPort {

    PlatoDto obtenerPlatoPorId(Long id);

    class PlatoDto {
        public Long id;
        public String nombre;
        public String descripcion;
        public String categoria;
        public Double precioSoles;
        public String imagenUrl;
    }
}
