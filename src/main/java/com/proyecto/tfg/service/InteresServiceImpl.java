package com.proyecto.tfg.service;

import com.proyecto.tfg.model.Interes;
import com.proyecto.tfg.service.db.InteresServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteresServiceImpl implements InteresService {

    @Autowired
    private InteresServiceJpa repo;

    @Override
    public List<Interes> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Interes buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Interes guardar(Interes interes) {
        return repo.save(interes);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}