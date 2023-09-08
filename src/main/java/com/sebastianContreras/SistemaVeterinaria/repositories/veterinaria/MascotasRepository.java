package com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends CrudRepository<Mascotas,Integer> {
}
