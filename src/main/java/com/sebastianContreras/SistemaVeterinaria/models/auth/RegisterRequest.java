package com.sebastianContreras.SistemaVeterinaria.models.auth;

import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String dni;
    private String username;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private String direccion;
    private Roles perfilRol;
}