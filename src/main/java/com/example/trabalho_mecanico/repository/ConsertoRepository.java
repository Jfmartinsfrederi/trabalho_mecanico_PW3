package com.example.trabalho_mecanico.repository;

import com.example.trabalho_mecanico.model.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsertoRepository extends JpaRepository<Conserto, UUID> {
}
