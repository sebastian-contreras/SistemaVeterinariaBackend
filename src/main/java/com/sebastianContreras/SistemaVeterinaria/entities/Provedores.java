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
@Table(name = "provedores")
public class Provedores {
    @Id
    private String CUIL;
    private String Direccion;
    private String Telefono;
    private Boolean Estado;
    private String Email;
    private String Nombre;

//    COMPRAS
    @OneToMany(mappedBy = "proveedor")
    private List<Compras> comprasProvedor;
}
