package com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;

import java.util.List;
import java.util.Optional;

public interface IMascotasDAO {
    Optional<Mascotas> encontrarMascotaId(Integer id);
    List<Mascotas> mascotasDeDueno(String dni);
    List<Mascotas> todasMascotas();
    void save(Mascotas mascota);
    void deleteMascota(Integer id);


}
