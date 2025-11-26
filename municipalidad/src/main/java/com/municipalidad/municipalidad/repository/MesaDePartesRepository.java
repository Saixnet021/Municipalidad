package com.municipalidad.municipalidad.repository;

import com.municipalidad.municipalidad.entity.MesaDePartes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MesaDePartesRepository extends JpaRepository<MesaDePartes, Long> {
}
