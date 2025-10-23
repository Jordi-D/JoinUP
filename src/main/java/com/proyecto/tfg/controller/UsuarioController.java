package com.proyecto.tfg.controller;


import com.proyecto.tfg.constants.TFGConstants;
import com.proyecto.tfg.model.Response;
import com.proyecto.tfg.model.Usuario;
import com.proyecto.tfg.service.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

/*    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findByIdCliente(@PathVariable Integer id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }*/

    @PostMapping("/create")
    public ResponseEntity<Response> createAccount(@Valid @RequestBody Usuario usuario) {
        usuarioService.createAccount(usuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response(TFGConstants.STATUS_201, TFGConstants.MESSAGE_201));
    }
/*    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario existente = usuarioService.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        usuario.setIdUsuario(id);
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }*/
}