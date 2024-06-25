package com.PracticaSpringBootAdv.AdoptaMe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TBL_PETS")
@Data
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pets")
    private Long id;

    @Size(min=3, message = "El nombre debe tener al menos 5 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nac")
    private LocalDate fechaNac;

    @Column(name = "raza", nullable = false)
    private String raza;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "tiene_chip", nullable = false)
    private boolean tieneChip;

    @Column(name = "url_foto", nullable = false)
    private String urlFoto;

    @OneToMany(mappedBy = "mascota")
    @JsonIgnore
    private List<MascotaAdoptada> adopciones;

}