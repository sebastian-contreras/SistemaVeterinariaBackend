package com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMascotasDAO {
    Optional<Mascotas> encontrarMascotaId(Integer id);
    List<Mascotas> mascotasDeDueno(String dni);
    List<Mascotas> todasMascotas(Pageable pageable);
    List<Mascotas> todasMascotas();

    void save(Mascotas mascota);
    void deleteMascota(Integer id);


}
