package com.sebastianContreras.SistemaVeterinaria.repositories.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.comercio.LineaDeVentas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaVentasRepository extends CrudRepository<LineaDeVentas,Integer> {
}
