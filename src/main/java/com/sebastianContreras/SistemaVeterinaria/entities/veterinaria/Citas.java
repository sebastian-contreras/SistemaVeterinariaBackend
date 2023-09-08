package com.sebastianContreras.SistemaVeterinaria.entities.veterinaria;

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
    private Integer idCita;
    private Date Fecha;
    private String Consultorio;
    private Float Monto;

//    Diagnostico
    private Boolean Estado;
    private String Titulo;
    private String Imagenes;
    private String Descripcion;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "int", name = "idMascotas")
    private Mascotas mascota;

    @ManyToOne(optional = false)
    @JoinColumn(columnDefinition = "VARCHAR(10)", name = "Veterinario_DNI")
    private Personas veterinario;
}
