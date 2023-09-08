package com.sebastianContreras.SistemaVeterinaria.repositories.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.comercio.Ventas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends CrudRepository<Ventas,Integer> {
}
