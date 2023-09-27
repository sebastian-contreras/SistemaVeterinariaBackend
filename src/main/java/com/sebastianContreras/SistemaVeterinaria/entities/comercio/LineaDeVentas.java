package com.sebastianContreras.SistemaVeterinaria.entities.comercio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lineaDeVentas")
public class LineaDeVentas {
    @Id
    private Integer idLineaDeVenta;
    private Float PrecioUnidad;
    private Integer Cantidad;

    @ManyToOne
    @JoinColumn(name = "idVentas")
    @JsonIgnore
    private Ventas ventas;
}
