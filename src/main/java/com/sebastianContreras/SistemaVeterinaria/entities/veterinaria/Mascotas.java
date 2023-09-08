package com.sebastianContreras.SistemaVeterinaria.entities.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Sexo;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.TipoMascotas;
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
@Table(name = "mascotas")
public class Mascotas {
    @Id
    private Integer idMascotas;
    private String Nombre;
    @Temporal(value = TemporalType.DATE)
    private Date FechaDeNacimiento;
    @Enumerated(value = EnumType.STRING)
    private TipoMascotas Tipo;
    private String urlFoto;
    @Enumerated(value = EnumType.STRING)
    private Sexo sexo;

    @ManyToOne()
    @JoinColumn(name = "Dueno_DNI")
    private Personas dueno;

    @OneToMany(mappedBy = "mascota")
    private List<Citas> citas;

}
