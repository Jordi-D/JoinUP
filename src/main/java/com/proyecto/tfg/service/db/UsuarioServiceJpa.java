package com.proyecto.tfg.service.db;

import com.proyecto.tfg.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioServiceJpa extends JpaRepository<Usuario, Integer> {

    @Transactional
    @Modifying
    void deleteByIdCliente(Long usuarioId);

    Optional<Usuario> findByEmail(String email);

}
