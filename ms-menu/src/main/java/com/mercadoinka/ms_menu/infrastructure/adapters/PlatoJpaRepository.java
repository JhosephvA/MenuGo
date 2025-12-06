package com.mercadoinka.ms_menu.infrastructure.adapters;

import com.mercadoinka.ms_menu.infrastructure.adapters.entities.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoJpaRepository extends JpaRepository<PlatoEntity, Long> {
}
