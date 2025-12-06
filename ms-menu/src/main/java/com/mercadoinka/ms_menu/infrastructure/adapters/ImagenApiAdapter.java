package com.mercadoinka.ms_menu.infrastructure.adapters;

import com.mercadoinka.ms_menu.application.ports.out.ImagenApiPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class ImagenApiAdapter implements ImagenApiPort {

    private final RestTemplate client = new RestTemplate();

    @Override
    public String obtenerImagenAleatoria() {
        Map response = client.getForObject("https://foodish-api.com/api/", Map.class);
        return (String) response.get("image");
    }
}
