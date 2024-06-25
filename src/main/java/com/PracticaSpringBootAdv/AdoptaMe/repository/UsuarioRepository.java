package com.PracticaSpringBootAdv.AdoptaMe.repository;

import com.PracticaSpringBootAdv.AdoptaMe.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}