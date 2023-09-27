package com.sebastianContreras.SistemaVeterinaria.persistence;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.Provedores;

import java.util.List;
import java.util.Optional;

public interface IProvedoresDAO {
    List<Provedores> todosProvedores();
    Optional<Provedores> provedorByCuil(String Cuil);
    void save(Provedores newProvedor);
    void deleteByCuil(String CUIL);

}
