package com.sebastianContreras.SistemaVeterinaria.entities;

import com.sebastianContreras.SistemaVeterinaria.entities.comercio.Compras;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proveedores")
public class Provedores {
    @Id
    private String cuil;
    private String direccion;
    private String telefono;
    private Boolean estado;
    private String email;
    private String nombre;

//    COMPRAS
    @OneToMany(mappedBy = "proveedor")
    private List<Compras> comprasProvedor;
}
