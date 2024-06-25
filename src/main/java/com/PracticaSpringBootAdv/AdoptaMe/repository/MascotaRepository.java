package com.PracticaSpringBootAdv.AdoptaMe.repository;

import com.PracticaSpringBootAdv.AdoptaMe.entities.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota,Long> {
    List<Mascota> findByNombre(String nombre);
    List<Mascota> findByOrderByFechaNacDesc();
}
