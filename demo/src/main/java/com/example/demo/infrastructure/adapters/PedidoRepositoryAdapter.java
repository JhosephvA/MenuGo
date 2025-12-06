package com.example.demo.infrastructure.adapters;

import com.example.demo.application.ports.out.PedidoRepositoryPort;
import com.example.demo.domain.model.EstadoPedido;
import com.example.demo.domain.model.Pedido;
import com.example.demo.domain.model.PedidoItem;
import com.example.demo.infrastructure.persistence.PedidoEntity;
import com.example.demo.infrastructure.persistence.PedidoItemEntity;
import com.example.demo.infrastructure.persistence.PedidoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository jpaRepository;

    @Override
    public Pedido guardar(Pedido pedido) {
        PedidoEntity entity = toEntity(pedido);
        PedidoEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Pedido> listar() {
        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    // -------------------------
    // MAPPERS DOMAIN → ENTITY
    // -------------------------
    private PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();

        entity.setId(pedido.getId());
        entity.setFecha(pedido.getFecha());
        entity.setEstado(pedido.getEstado().name());
        entity.setMoneda(pedido.getMoneda());
        entity.setTotal(pedido.getTotal());
        entity.setTotalSoles(pedido.getTotalSoles());

        List<PedidoItemEntity> itemEntities = pedido.getItems()
                .stream()
                .map(item -> {
                    PedidoItemEntity e = new PedidoItemEntity();
                    e.setId(item.getId());
                    e.setPlatoId(item.getPlatoId());
                    e.setNombrePlato(item.getNombrePlato());
                    e.setCantidad(item.getCantidad());
                    e.setPrecioUnitario(item.getPrecioUnitario());
                    e.setSubtotal(item.getSubtotal());
                    e.setPedido(entity);
                    return e;
                })
                .collect(Collectors.toList());

        entity.setItems(itemEntities);
        return entity;
    }

    // -------------------------
    // MAPPERS ENTITY → DOMAIN
    // -------------------------
    private Pedido toDomain(PedidoEntity entity) {
        Pedido pedido = new Pedido();

        pedido.setId(entity.getId());
        pedido.setFecha(entity.getFecha());
        pedido.setEstado(EstadoPedido.valueOf(entity.getEstado()));
        pedido.setMoneda(entity.getMoneda());
        pedido.setTotal(entity.getTotal());
        pedido.setTotalSoles(entity.getTotalSoles());

        List<PedidoItem> items = entity.getItems()
                .stream()
                .map(e -> {
                    PedidoItem item = new PedidoItem();
                    item.setId(e.getId());
                    item.setPlatoId(e.getPlatoId());
                    item.setNombrePlato(e.getNombrePlato());
                    item.setCantidad(e.getCantidad());
                    item.setPrecioUnitario(e.getPrecioUnitario());
                    item.setSubtotal(e.getSubtotal());
                    return item;
                })
                .collect(Collectors.toList());

        pedido.setItems(items);
        return pedido;
    }
}
