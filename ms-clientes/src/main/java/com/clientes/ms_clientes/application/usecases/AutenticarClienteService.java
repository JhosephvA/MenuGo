package com.clientes.ms_clientes.application.usecases;

import com.clientes.ms_clientes.application.ports.in.AutenticarClienteUseCase;
import com.clientes.ms_clientes.application.ports.out.ClienteRepositoryPort;
import com.clientes.ms_clientes.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticarClienteService implements AutenticarClienteUseCase {

    private final ClienteRepositoryPort repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public String login(String email, String password) {

        var cliente = repo.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Email no registrado"));

        if (!passwordEncoder.matches(password, cliente.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generarToken(email);
    }
}
