package com.municipalidad.municipalidad.repository;

import com.municipalidad.municipalidad.entity.ConstanciaResidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstanciaResidenciaRepository extends JpaRepository<ConstanciaResidencia, Long> {
}
