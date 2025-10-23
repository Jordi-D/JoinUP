package com.proyecto.tfg.service;

import com.proyecto.tfg.exception.UserAlreadyExistsException;
import com.proyecto.tfg.model.Rol;
import com.proyecto.tfg.model.Usuario;
import com.proyecto.tfg.service.db.UsuarioServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioServiceJpa repo;


    @Override
    public void createAccount(Usuario usuario) {
        Optional<Usuario> optionalUsuario = repo.findByEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            throw new UserAlreadyExistsException("Customer already registered with given mobileNumber " + usuario.getEmail());
        }
        repo.save(createNewAccount(usuario));
    }
    private Usuario createNewAccount(Usuario usuario) {
        Usuario newUsuario = new Usuario();
        newUsuario.setNombre(usuario.getNombre());
        newUsuario.setAp1(usuario.getAp1());
        newUsuario.setAp2(usuario.getAp2());
        newUsuario.setEmail(usuario.getEmail());       // 🔹 importante
        newUsuario.setPassword(usuario.getPassword());

        // Si no viene rol, ponemos el valor por defecto
        if (usuario.getRol() == null) {
            newUsuario.setRol(Rol.GRATUITO);
        } else {
            newUsuario.setRol(usuario.getRol());
        }

        newUsuario.setDireccion(usuario.getDireccion());
        newUsuario.setInteres(usuario.getInteres());

        return newUsuario;
    }

    @Override
    public Usuario fetchAccount(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateAccount(Usuario usuario) {
        return false;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        return false;
    }
}