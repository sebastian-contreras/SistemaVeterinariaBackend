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
public class HistoriaDto {
    private Integer idCita;
    private Date fecha;
    private String consultorio;
    private Float monto;

    //    Diagnostico
    private Boolean estado;
    private String titulo;
    private String imagenes;
    private String descripcion;

    private  String veterinario;
    private Integer mascota;

}
