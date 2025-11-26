package com.municipalidad.municipalidad.repository;

import com.municipalidad.municipalidad.entity.PagoArbitrios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoArbitriosRepository extends JpaRepository<PagoArbitrios, Long> {
}
