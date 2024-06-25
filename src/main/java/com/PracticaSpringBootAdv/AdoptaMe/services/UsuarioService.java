package com.PracticaSpringBootAdv.AdoptaMe.services;

import com.PracticaSpringBootAdv.AdoptaMe.entities.Usuario;
import com.PracticaSpringBootAdv.AdoptaMe.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.PracticaSpringBootAdv.AdoptaMe.exception.Exception;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario registrarUsuario(Usuario usuario) {
        return repo.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        if(!this.repo.existsById(id)) {
            throw new Exception("(El usuario no existe)");
        }
        return repo.findById(id).orElse(null);
    }

    public List<Usuario> listarTodosLosUsuarios() {
        return (List<Usuario>) this.repo.findAll();
    }

    public void borrarUsuario(Long id) {
        if(!this.repo.existsById(id)) {
            throw new Exception("(El usuario no existe)");
        }
        this.repo.deleteById(id);
    }

    public Usuario modificarPersona(Long id, Usuario usuarioModificado) {
        if (!this.repo.existsById(id)) {
            throw new Exception("(El usuario no existe)");
        }
        usuarioModificado.setId(id);
        return this.repo.save(usuarioModificado);
    }
}
