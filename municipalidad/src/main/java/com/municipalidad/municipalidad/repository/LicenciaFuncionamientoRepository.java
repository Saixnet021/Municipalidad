package com.municipalidad.municipalidad.repository;

import com.municipalidad.municipalidad.entity.LicenciaFuncionamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciaFuncionamientoRepository extends JpaRepository<LicenciaFuncionamiento, Long> {
}
