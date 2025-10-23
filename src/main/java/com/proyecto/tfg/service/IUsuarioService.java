package com.proyecto.tfg.service;

import com.proyecto.tfg.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    void createAccount(Usuario usuario);

    Usuario fetchAccount(String mobileNumber);


    boolean updateAccount(Usuario usuario);


    boolean deleteAccount(String mobileNumber);
}
