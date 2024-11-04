package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}


