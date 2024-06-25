package com.PracticaSpringBootAdv.AdoptaMe.controller;

import com.PracticaSpringBootAdv.AdoptaMe.entities.Usuario;
import com.PracticaSpringBootAdv.AdoptaMe.repository.MascotaAdoptadaRepository;
import com.PracticaSpringBootAdv.AdoptaMe.services.UsuarioService;
import com.PracticaSpringBootAdv.AdoptaMe.entities.MascotaAdoptada;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MascotaAdoptadaRepository mascotaAdoptadaRepository;

    // Operación para mostrar un usuario por su ID
    @ApiOperation(value = "Obtener Usuario por ID", notes = "Obtiene un usuario por su ID")
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    // Operación para registrar un usuario
    @ApiOperation(value = "Registrar Usuario", notes = "Registra un nuevo usuario en el sistema")
    @PostMapping("/registrar")
    public Usuario registrarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    // Operación para mostrar todos los usuarios
    @ApiOperation(value = "Listar Todos los Usuarios", notes = "Obtiene una lista de todos los usuarios registrados")
    @GetMapping
    public List<Usuario> listarTodasLasPersonas() {
        return usuarioService.listarTodosLosUsuarios();
    }

    // Operación para borrar un usuario
    @ApiOperation(value = "Borrar Usuario", notes = "Elimina un usuario del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable Long id) {
        List<MascotaAdoptada> adopciones = mascotaAdoptadaRepository.findByUsuarioId(id);
        mascotaAdoptadaRepository.deleteAll(adopciones);
        usuarioService.borrarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Operación para modificar un usuario
    @ApiOperation(value = "Modificar Usuario", notes = "Modifica los datos de un usuario existente")
    @PutMapping("/{id}")
    public Usuario modificarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioModificado) {
        return usuarioService.modificarPersona(id, usuarioModificado);
    }


}
