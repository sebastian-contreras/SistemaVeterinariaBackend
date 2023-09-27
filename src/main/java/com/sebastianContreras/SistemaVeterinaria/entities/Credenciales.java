package com.sebastianContreras.SistemaVeterinaria.entities;

import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credenciales")
public class Credenciales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCredencial;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "personas_DNI",columnDefinition = "Varchar(10)")
    private Personas persona;

    private String usuario;
    @Column(columnDefinition = "CHAR(32)")
    private String password;
    @Column(columnDefinition = "INT(1)")
    @Enumerated(value = EnumType.ORDINAL)
    private Roles rol;


}
