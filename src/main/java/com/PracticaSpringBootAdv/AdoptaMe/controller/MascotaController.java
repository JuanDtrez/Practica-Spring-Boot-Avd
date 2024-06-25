package com.PracticaSpringBootAdv.AdoptaMe.controller;

import com.PracticaSpringBootAdv.AdoptaMe.entities.Mascota;
import com.PracticaSpringBootAdv.AdoptaMe.entities.MascotaAdoptada;
import com.PracticaSpringBootAdv.AdoptaMe.repository.MascotaAdoptadaRepository;
import com.PracticaSpringBootAdv.AdoptaMe.services.MascotaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private MascotaAdoptadaRepository mascotaAdoptadaRepository;

    // Operación para mostrar una mascota por su ID
    @ApiOperation(value = "Mostrar Mascota por ID", notes = "Obtiene una mascota por su ID")
    @GetMapping("/{id}")
    public Mascota mostrarMascotaPorId(@PathVariable Long id) {
        return mascotaService.obtenerMascotaPorId(id);
    }

    // Operación para subir una mascota
    @ApiOperation(value = "Subir una Mascota", notes = "Sube una nueva mascota al sistema")
    @PostMapping("/subir")
    public Mascota subirMascota(@Valid @RequestBody Mascota mascota) {
        return mascotaService.subirMascota(mascota);
    }

    // Operación para listar todas las mascotas
    @ApiOperation(value = "Listar todas las mascotas", notes = "Obtiene todas las mascotas registradas")
    @GetMapping
    public List<Mascota> listarTodasLasMascotas() {
        return mascotaService.listarTodasLasMascotas();
    }

    // Operación para listar las 20 mascotas más jóvenes
    @ApiOperation(value = "Listar las 20 mascotas más jóvenes", notes = "Obtiene las 20 mascotas más jóvenes registradas")
    @GetMapping("/jovenes")
    public List<Mascota> listarMascotasMasJovenes() {
        return mascotaService.listarMascotasMasJovenes();
    }

    // Operación para mostrar todas las mascotas en páginas de a 5
    @ApiOperation(value = "Mostrar todas las mascotas en páginas de a 5", notes = "Obtiene las mascotas paginadas")
    @GetMapping("/paginas")
    public List<Mascota> mostrarMascotasEnPaginas(@RequestParam(defaultValue = "0") int pagina) {
        return mascotaService.mostrarMascotasEnPaginas(pagina);
    }

    // Operación para borrar una mascota
    @ApiOperation(value = "Borrar una Mascota", notes = "Elimina una mascota del sistema por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarMascota(@PathVariable Long id) {
        List<MascotaAdoptada> adopciones = mascotaAdoptadaRepository.findByMascotaId(id);
        mascotaAdoptadaRepository.deleteAll(adopciones);
        mascotaService.borrarMascota(id);
        return ResponseEntity.noContent().build();
    }

    // Operación para mostrar una mascota por su nombre
    @ApiOperation(value = "Mostrar mascota por nombre", notes = "Obtiene una mascota por su nombre")
    @GetMapping("/nombre/{nombre}")
    public Mascota mostrarMascotaPorNombre(@PathVariable String nombre) {
        return mascotaService.mostrarMascotaPorNombre(nombre);
    }

    // Operación para mostrar una mascota por su nombre
    @ApiOperation(value = "Modificar mascota", notes = "Modifica una mascota por medio de su id")
    @PutMapping("/{id}")
    public Mascota actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        return mascotaService.modificarMascota(id, mascota);
    }

}

