package com.sebastianContreras.SistemaVeterinaria.entities;

import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insumos")

public class Insumos {
    @Id
    private Integer idInsumos;
    private String Nombre;
    private Integer Cantidad;
    private Float precioRefVenta;

}
