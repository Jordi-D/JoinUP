package com.proyecto.tfg.service;

import com.proyecto.tfg.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    void createAccount(Usuario usuario);

    Optional<Usuario> fetchAccount(int idCliente);

    List<Usuario> findAll();

    boolean updateAccount(Usuario usuario);


    boolean deleteAccount(int idCliente);
}
