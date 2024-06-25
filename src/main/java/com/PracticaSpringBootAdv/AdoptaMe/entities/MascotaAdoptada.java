package com.PracticaSpringBootAdv.AdoptaMe.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_ADOPTIONS")
@Data
public class MascotaAdoptada implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_Adopcion")
    private LocalDate fechaAdopcion;

}
