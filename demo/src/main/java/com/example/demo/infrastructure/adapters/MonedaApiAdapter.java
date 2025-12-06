package com.example.demo.infrastructure.adapters;

import com.example.demo.application.ports.out.MonedaApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MonedaApiAdapter implements MonedaApiPort {

    @Override
    public Double convertir(Double monto, String monedaDestino) {
        if (monto == null) {
            return null;
        }

        if (monedaDestino == null || monedaDestino.isBlank()) {
            return monto;
        }

        String moneda = monedaDestino.toUpperCase();

        // Si es PEN, no convertimos
        if ("PEN".equals(moneda)) {
            return monto;
        }

        // 🚀 TIPOS DE CAMBIO DE EJEMPLO (puedes ajustarlos)
        switch (moneda) {
            case "USD":
                // Ejemplo: 1 USD = 3.8 PEN
                return monto / 3.8;
            case "EUR":
                // Ejemplo: 1 EUR = 4.1 PEN
                return monto / 4.1;
            default:
                // Si no reconocemos la moneda, devolvemos el mismo monto
                return monto;
        }
    }
}
