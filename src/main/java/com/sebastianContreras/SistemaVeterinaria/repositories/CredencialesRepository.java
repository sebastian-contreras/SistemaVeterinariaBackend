package com.sebastianContreras.SistemaVeterinaria.repositories;

import com.sebastianContreras.SistemaVeterinaria.entities.Credenciales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredencialesRepository extends CrudRepository<Credenciales,String> {
    Optional<Credenciales> findByUsuario(String username);

}
