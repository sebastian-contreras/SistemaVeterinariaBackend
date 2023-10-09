package com.sebastianContreras.SistemaVeterinaria.persistence.impl;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import com.sebastianContreras.SistemaVeterinaria.persistence.IPersonasDAO;
import com.sebastianContreras.SistemaVeterinaria.repositories.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonasDAO implements IPersonasDAO {
    @Autowired
    private PersonasRepository repositorio;

    @Override
    public List<Personas> todasPersonas() {
        return (List<Personas>) repositorio.findAll();
    }

    @Override
        public List<Personas> todosClientes(Pageable pageable) {
        return repositorio.findByPerfilRol(Roles.USUARIO,pageable);
    }

    @Override
    public List<Personas> todosClientes() {
        return repositorio.findByPerfilRol(Roles.USUARIO);
    }
    @Override
    public List<Personas> todosVeterinarios() {
        return repositorio.findByPerfilRol(Roles.VETERINARIO);
    }
    @Override
    public List<Personas> todosEmpleados() {
        return repositorio.findByPerfilRol(Roles.EMPLEADO);
    }


    @Override
    public Optional<Personas> personaByDNI(String DNI) {
        return repositorio.findById(DNI);
    }

    @Override
    public void save(Personas persona) {
        repositorio.save(persona);
    }

    @Override
    public void deleteByDNI(String DNI) {
        repositorio.deleteById(DNI);
    }
}
