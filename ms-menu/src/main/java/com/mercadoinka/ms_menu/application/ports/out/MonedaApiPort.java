package com.mercadoinka.ms_menu.application.ports.out;

public interface MonedaApiPort {
    double convertir(double monto, String monedaDestino);
}
