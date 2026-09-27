package com.cibertec.msriesgo.repositorio;

import com.cibertec.msriesgo.entidades.Analisis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalisisRepository extends JpaRepository<Analisis, Long> {
}
