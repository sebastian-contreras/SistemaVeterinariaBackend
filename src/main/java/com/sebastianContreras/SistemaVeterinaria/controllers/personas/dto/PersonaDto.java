package com.sebastianContreras.SistemaVeterinaria.controllers.personas.dto;

import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDto {
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private Roles perfilRol;

}
