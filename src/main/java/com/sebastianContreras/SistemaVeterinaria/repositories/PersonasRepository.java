package com.sebastianContreras.SistemaVeterinaria.repositories;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepository extends CrudRepository<Personas,String> {
    List<Personas> findByPerfilRol(Roles rol);
}
