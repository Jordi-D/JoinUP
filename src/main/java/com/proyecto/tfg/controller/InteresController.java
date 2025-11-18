package com.proyecto.tfg.controller;

import java.util.List;

import com.proyecto.tfg.model.Interes;
import com.proyecto.tfg.service.InteresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/intereses")
@CrossOrigin(origins = "*")
public class InteresController {

    @Autowired
    private InteresService interesService;

    @GetMapping
    public List<Interes> listarTodos() {
        return interesService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interes> buscarPorId(@PathVariable Integer id) {
        Interes interes = interesService.buscarPorId(id);
        return interes != null ? ResponseEntity.ok(interes) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Interes guardar(@RequestBody Interes interes) {
        return interesService.guardar(interes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interes> actualizar(@PathVariable Integer id, @RequestBody Interes interes) {
        Interes existente = interesService.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        interes.setIdInteres(id);
        return ResponseEntity.ok(interesService.guardar(interes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        interesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}