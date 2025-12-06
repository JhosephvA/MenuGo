package com.example.demo.infrastructure.adapters;

import com.example.demo.application.ports.out.MenuApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MenuApiAdapter implements MenuApiPort {

    private final RestTemplate restTemplate;

    @Value("${ms-menu.url:http://localhost:8080}")
    private String msMenuUrl;

    @Override
    public PlatoDto obtenerPlatoPorId(Long id) {
        String url = msMenuUrl + "/menu/" + id;
        return restTemplate.getForObject(url, PlatoDto.class);
    }
}
