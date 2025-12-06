package com.mercadoinka.ms_menu.application.ports.in;

public interface ConvertirPrecioUseCase {
    double convertir(double monto, String monedaDestino);
}
