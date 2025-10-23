package com.proyecto.tfg.service.db;

import com.proyecto.tfg.model.Interes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresServiceJpa extends JpaRepository<Interes, Integer> {
}
