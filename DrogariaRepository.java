package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Drogaria;

public interface DrogariaRepository extends JpaRepository<Drogaria, Long> {
}
