package com.sebastianContreras.SistemaVeterinaria.entities;

import com.sebastianContreras.SistemaVeterinaria.entities.comercio.Ventas;
import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Citas;
import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personas")
public class Personas {

    @Id
    private String DNI;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Email;
    private String Matricula;
    private String Direccion;

    @OneToMany(mappedBy = "dueno")
    private List<Mascotas> mascotas;

    @OneToMany(mappedBy = "veterinario")
    private List<Citas> CitasVeterinario;

    @OneToMany(mappedBy = "encargado")
    List<Ventas> ventasRealizadas;

}
