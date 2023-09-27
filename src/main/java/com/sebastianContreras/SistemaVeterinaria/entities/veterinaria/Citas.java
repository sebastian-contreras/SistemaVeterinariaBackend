package com.sebastianContreras.SistemaVeterinaria.entities.veterinaria;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;
    private Date fecha;
    private String consultorio;
    private Float monto;

//    Diagnostico
    private Boolean estado;
    private String titulo;
    private String imagenes;
    private String descripcion;



    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "VARCHAR(10)", name = "veterinario_dni")
//    @JsonIgnore
    private Personas veterinario;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "INT", name = "id_mascotas")
//    @JsonIgnore
    private Mascotas mascota;
}
