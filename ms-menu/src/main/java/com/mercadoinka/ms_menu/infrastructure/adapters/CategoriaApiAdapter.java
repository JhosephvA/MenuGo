package com.mercadoinka.ms_menu.infrastructure.adapters;

import com.mercadoinka.ms_menu.application.ports.out.CategoriaApiPort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class CategoriaApiAdapter implements CategoriaApiPort {

    private final RestTemplate client = new RestTemplate();

    @Override
    public List<String> obtenerCategorias() {
        Map response = client.getForObject(
                "https://www.themealdb.com/api/json/v1/1/categories.php",
                Map.class);

        List<Map> categories = (List<Map>) response.get("categories");

        return categories.stream()
                .map(c -> (String) c.get("strCategory"))
                .toList();
    }
}
