package com.PracticaSpringBootAdv.AdoptaMe.repository;

import com.PracticaSpringBootAdv.AdoptaMe.entities.MascotaAdoptada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaAdoptadaRepository extends JpaRepository<MascotaAdoptada, Long> {
    List<MascotaAdoptada> findByUsuarioId(Long usuarioId);
    List<MascotaAdoptada> findByMascotaId(Long mascotaId);
}
