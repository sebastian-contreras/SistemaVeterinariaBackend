package com.sebastianContreras.SistemaVeterinaria.repositories.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.comercio.Compras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends CrudRepository<Compras,Integer> {
}
