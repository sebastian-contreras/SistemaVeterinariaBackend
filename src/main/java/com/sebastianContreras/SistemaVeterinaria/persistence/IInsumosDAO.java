package com.sebastianContreras.SistemaVeterinaria.persistence;


import com.sebastianContreras.SistemaVeterinaria.entities.Insumos;

import java.util.List;
import java.util.Optional;

public interface IInsumosDAO {
    List<Insumos> todosInsumos();
    Optional<Insumos> insumobyId(Integer idInsumo);
    void save(Insumos newInsumo);
    void deleteById(Integer idInsumo);
}
