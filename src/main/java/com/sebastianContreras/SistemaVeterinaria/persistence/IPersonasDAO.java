package com.sebastianContreras.SistemaVeterinaria.persistence;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IPersonasDAO {
    List<Personas> todasPersonas();

    List<Personas> todosClientes(Pageable pageable);
    List<Personas> todosClientes();

    List<Personas> todosVeterinarios();

    List<Personas> todosEmpleados();

    Optional<Personas> personaByDNI(String CUIL);
    void save(Personas persona);
    void deleteByDNI(String DNI);




}
