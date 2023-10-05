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
public class AuthResponse {
    private String username;
    private String dni;
    private String token;
    private String nombre;
    private String apellido;
    private Roles rol;
}