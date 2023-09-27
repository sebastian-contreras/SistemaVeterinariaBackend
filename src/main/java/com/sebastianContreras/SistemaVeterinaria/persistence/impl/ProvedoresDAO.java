package com.sebastianContreras.SistemaVeterinaria.persistence.impl;

import com.sebastianContreras.SistemaVeterinaria.entities.Provedores;
import com.sebastianContreras.SistemaVeterinaria.persistence.IProvedoresDAO;
import com.sebastianContreras.SistemaVeterinaria.repositories.ProvedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProvedoresDAO implements IProvedoresDAO {
    @Autowired
    private ProvedoresRepository repository;
    @Override
    public List<Provedores> todosProvedores() {
        return (List<Provedores>) repository.findAll();
    }

    @Override
    public Optional<Provedores> provedorByCuil(String Cuil) {
        return repository.findById(Cuil);
    }

    @Override
    public void save(Provedores newProvedor) {
        repository.save(newProvedor);
    }

    @Override
    public void deleteByCuil(String CUIL) {
        repository.deleteById(CUIL);
    }

}
