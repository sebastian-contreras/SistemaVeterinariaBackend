package com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Citas;

import java.util.List;
import java.util.Optional;

public interface ICitasDAO {
    List<Citas> todasCitas();
    List<Citas> citasByDniCliente(String dni);
    List<Citas> citasDeVeterinario(String dni);
    List<Citas> citasPendiente();
    List<Citas> historiaMascota(Integer id);

    List<Citas> citasPendientesByCliente(String dni);

    List<Citas> citasPendientesByMascota(Integer id);

    Optional<Citas> citaById(Integer id);
    void save(Citas newCita);
    void deleteById(Integer id);
}
