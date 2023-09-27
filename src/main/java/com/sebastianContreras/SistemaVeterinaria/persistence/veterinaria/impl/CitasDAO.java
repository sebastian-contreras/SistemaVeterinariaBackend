package com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.impl;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Citas;
import com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.ICitasDAO;
import com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CitasDAO implements ICitasDAO {
    @Autowired
    private CitasRepository repository;
    @Override
    public List<Citas> todasCitas() {
        return (List<Citas>) repository.findAll();
    }

    @Override
    public List<Citas> citasByDniCliente(String dni) {
        return repository.findCitasByCliente(dni);
    }

    @Override
    public List<Citas> citasDeVeterinario(String dni) {
        return repository.findByVeterinarioDni(dni);
    }

    @Override
    public List<Citas> citasPendiente() {
        return repository.findByEstado(false);
    }

    @Override
    public List<Citas> historiaMascota(Integer id) {
        return repository.findByCitasPendientesMascota(id,true);
    }

    @Override
    public List<Citas> citasPendientesByCliente(String dni) {
        return repository.findCitasByClientePendiente(dni);
    }
    @Override
    public List<Citas> citasPendientesByMascota(Integer id) {
        return repository.findByCitasPendientesMascota(id,false);

    }

    @Override
    public Optional<Citas> citaById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void save(Citas newCita) {
        repository.save(newCita);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
