package com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria.dto;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Sexo;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.TipoMascotas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MascotasDto {
    private Integer IdMascotas;
    private String nombre;
    private Date fechaDeNacimiento;
    private TipoMascotas tipo;
    private String urlFoto;
    private Sexo sexo;

    private String dueno;
}
