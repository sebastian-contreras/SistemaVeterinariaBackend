package com.sebastianContreras.SistemaVeterinaria.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sebastianContreras.SistemaVeterinaria.entities.comercio.Ventas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
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
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String matricula;
    private String direccion;

    @Column(name = "perfil_Rol",columnDefinition = "INT(1)")
    @Enumerated(value = EnumType.ORDINAL)
    private Roles perfilRol;

    @OneToMany(mappedBy = "dueno",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mascotas> mascotas;

    @OneToMany(mappedBy = "veterinario",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Citas> citasVeterinario;

    @OneToMany(mappedBy = "encargado",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Ventas> ventasRealizadas;

}
