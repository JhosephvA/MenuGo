package com.example.demo.application.ports.out;

public interface MonedaApiPort {
    Double convertir(Double monto, String monedaDestino);
}
