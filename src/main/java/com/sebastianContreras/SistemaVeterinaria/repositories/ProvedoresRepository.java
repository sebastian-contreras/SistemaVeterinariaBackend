package com.sebastianContreras.SistemaVeterinaria.repositories;

import com.sebastianContreras.SistemaVeterinaria.entities.Provedores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvedoresRepository extends CrudRepository<Provedores,String> {
}
