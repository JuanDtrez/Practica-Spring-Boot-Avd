package com.PracticaSpringBootAdv.AdoptaMe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TBL_USERS")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Size(min=5, message = "El nombre debe tener al menos 5 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;


    @NotBlank(message = "El email es requerido")
    @Email(message = "El email no es válido")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<MascotaAdoptada> mascotasAdoptadas;
}