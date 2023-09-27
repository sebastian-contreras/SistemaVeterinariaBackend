package com.sebastianContreras.SistemaVeterinaria.entities.veterinaria;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdMascotas;
    private String nombre;
    @Temporal(value = TemporalType.DATE)
    private Date fechaDeNacimiento;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(columnDefinition = "INT(1)")
    private TipoMascotas tipo;
    private String urlFoto;
    @Enumerated(value = EnumType.ORDINAL)
    @Column(columnDefinition = "INT(1)")
    private Sexo sexo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dueno_dni",columnDefinition = "VARCHAR(10)")
//    @JsonIgnore()
    private Personas dueno;

    @OneToMany(mappedBy = "mascota",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Citas> citas;

}
