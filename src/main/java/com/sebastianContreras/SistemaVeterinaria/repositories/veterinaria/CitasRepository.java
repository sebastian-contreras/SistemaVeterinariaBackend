package com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Citas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository extends CrudRepository<Citas,Integer> {
}
