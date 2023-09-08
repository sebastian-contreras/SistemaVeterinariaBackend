package com.sebastianContreras.SistemaVeterinaria.repositories.comercio;

import com.sebastianContreras.SistemaVeterinaria.entities.comercio.LineaDeCompras;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaComprasRepository extends CrudRepository<LineaDeCompras,Integer> {
}
