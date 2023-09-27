package com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CitasDto {
    private Integer idCita;
    private Date fecha;
    private String consultorio;
    private Boolean estado;

    private Float monto;
    private  String veterinario;
    private Integer mascota;
}
