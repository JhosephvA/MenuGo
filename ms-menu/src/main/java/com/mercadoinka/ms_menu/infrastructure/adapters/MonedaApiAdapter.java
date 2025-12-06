package com.mercadoinka.ms_menu.infrastructure.adapters;

import com.mercadoinka.ms_menu.application.ports.out.MonedaApiPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class MonedaApiAdapter implements MonedaApiPort {

    private final RestTemplate client = new RestTemplate();

    @Override
    public double convertir(double monto, String monedaDestino) {
        Map response = client.getForObject(
                "https://api.exchangerate-api.com/v4/latest/PEN",
                Map.class);

        Map<String, Double> rates = (Map<String, Double>) response.get("rates");

        return monto * rates.get(monedaDestino.toUpperCase());
    }
}
