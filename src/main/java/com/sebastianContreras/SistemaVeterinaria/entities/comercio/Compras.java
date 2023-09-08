package com.sebastianContreras.SistemaVeterinaria.entities.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.Provedores;
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
@Table(name = "compras")
public class Compras {
    @Id
    private Integer idCompras;

    private Date Fecha;

    @ManyToOne
    @JoinColumn(name = "Provedores_CUIL")
    private Provedores proveedor;

    @OneToMany(mappedBy = "compra")
    List<LineaDeCompras> lineasDeCompras;

}
