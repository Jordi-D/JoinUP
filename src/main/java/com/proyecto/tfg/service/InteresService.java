package com.proyecto.tfg.service;

import com.proyecto.tfg.model.Interes;

import java.util.List;

public interface InteresService {
    List<Interes> listarTodos();
    Interes buscarPorId(Integer id);
    Interes guardar(Interes interes);
    void eliminar(Integer id);
}
