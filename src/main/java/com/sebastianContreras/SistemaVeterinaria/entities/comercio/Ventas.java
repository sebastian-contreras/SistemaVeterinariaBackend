package com.sebastianContreras.SistemaVeterinaria.entities.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    private Integer idVentas;
    private Date Fecha;
    private String Servicio;

    @ManyToOne
    @JoinColumn(name = "Encargado_DNI")
    private Personas encargado;

    @OneToMany(mappedBy = "ventas")
    List<LineaDeVentas> lineasDeVentas;


}
