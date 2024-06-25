package com.PracticaSpringBootAdv.AdoptaMe.services;

import com.PracticaSpringBootAdv.AdoptaMe.entities.Mascota;
import com.PracticaSpringBootAdv.AdoptaMe.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import com.PracticaSpringBootAdv.AdoptaMe.exception.Exception;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository repo;

    public Mascota obtenerMascotaPorId(Long id){
        if (!this.repo.existsById(id)) {
            throw new Exception("(La mascota no existe)");
        }
        return this.repo.findById(id).get();
    }

    public Mascota subirMascota(Mascota mascota) {
        return this.repo.save(mascota);
    }

    public List<Mascota> listarTodasLasMascotas() {
        return (List<Mascota>) this.repo.findAll();
    }

    public List<Mascota> listarMascotasMasJovenes() {
        return repo.findByOrderByFechaNacDesc().stream().limit(20).toList();
    }

    public List<Mascota> mostrarMascotasEnPaginas(int pagina) {
        return repo.findAll(PageRequest.of(pagina - 1, 5)).getContent();
    }

    public void borrarMascota(Long id) {
        if(!this.repo.existsById(id)) {
            throw new Exception("(La mascota no existe)");
        }
        this.repo.deleteById(id);
    }

    public Mascota mostrarMascotaPorNombre(String nombre) {
        return this.repo.findByNombre(nombre).stream().findFirst().orElse(null);
    }

    public Mascota modificarMascota(Long id, Mascota mascotaModificada) {
        if (!this.repo.existsById(id)) {
            throw new Exception("(La mascota no existe)");
        }
        mascotaModificada.setId(id);
        return this.repo.save(mascotaModificada);
    }
}
