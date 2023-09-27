package com.sebastianContreras.SistemaVeterinaria.persistence.impl;

import com.sebastianContreras.SistemaVeterinaria.entities.Insumos;
import com.sebastianContreras.SistemaVeterinaria.persistence.IInsumosDAO;
import com.sebastianContreras.SistemaVeterinaria.repositories.InsumosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InsumosDAO implements IInsumosDAO {
    @Autowired
    private InsumosRepository repository;
    @Override
    public List<Insumos> todosInsumos() {
        return (List<Insumos>) repository.findAll();
    }

    @Override
    public Optional<Insumos> insumobyId(Integer idInsumo) {
        return repository.findById(idInsumo);
    }

    @Override
    public void save(Insumos newInsumo) {
        repository.save(newInsumo);
    }

    @Override
    public void deleteById(Integer idInsumo) {
        repository.deleteById(idInsumo);
    }
}
