package com.mercadoinka.ms_menu.application.usecases;

import com.mercadoinka.ms_menu.application.ports.in.ConvertirPrecioUseCase;
import com.mercadoinka.ms_menu.application.ports.out.MonedaApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConvertirPrecioService implements ConvertirPrecioUseCase {

    private final MonedaApiPort monedaApi;

    @Override
    public double convertir(double monto, String monedaDestino) {
        return monedaApi.convertir(monto, monedaDestino);
    }
}
