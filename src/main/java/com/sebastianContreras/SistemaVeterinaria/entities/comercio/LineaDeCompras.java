package com.sebastianContreras.SistemaVeterinaria.entities.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.Insumos;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lineaDeCompras")
public class LineaDeCompras {
    @Id
    private Integer idLineaDeCompras;
    private Float PrecioUnidad;
    private Integer Cantidad;

    @ManyToOne
    @JoinColumn(name = "idCompras")
    private Compras compra;

    @OneToOne
    @JoinColumn(name = "idInsumos")
    private Insumos insumo;
}
