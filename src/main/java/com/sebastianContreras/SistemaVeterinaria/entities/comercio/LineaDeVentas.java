package com.sebastianContreras.SistemaVeterinaria.entities.comercio;

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
    private Ventas ventas;
}
