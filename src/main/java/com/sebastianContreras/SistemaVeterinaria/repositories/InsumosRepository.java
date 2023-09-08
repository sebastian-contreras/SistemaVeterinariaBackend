package com.sebastianContreras.SistemaVeterinaria.repositories;

import com.sebastianContreras.SistemaVeterinaria.entities.Insumos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumosRepository extends CrudRepository<Insumos,Integer> {
}
