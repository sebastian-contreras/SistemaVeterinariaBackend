package com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.impl;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.IMascotasDAO;
import com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MascotasDAO implements IMascotasDAO {
    @Autowired
    private MascotasRepository repository;

    @Override
    public Optional<Mascotas> encontrarMascotaId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Mascotas> mascotasDeDueno(String dni) {
        return repository.findByDuenoDni(dni);
    }

    @Override
    public List<Mascotas> todasMascotas(Pageable pageable) {
        return (List<Mascotas>) repository.findAll(pageable);
    }

    @Override
    public List<Mascotas> todasMascotas() {
        return (List<Mascotas>) repository.findAll();
    }

    @Override
    public void save(Mascotas mascota) {
        repository.save(mascota);
    }

    @Override
    public void deleteMascota(Integer id) {
        repository.deleteById(id);
    }


}
