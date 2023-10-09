package com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MascotasRepository extends CrudRepository<Mascotas,Integer> {
    List<Mascotas> findByDuenoDni(String dni);
    List<Mascotas> findAll(Pageable pageable);

    @Query(value = "Select tipo,cantidad from ClaseMascotas",nativeQuery = true)
    List<Map<String, Object>> cantidadClaseMascota();

    @Query(value = "Select sexo,cantidad from SexoMascotas",nativeQuery = true)
    List<Map<String, Object>> sexoMascota();

    @Query(value = "Select tipo,cantidad from CitasTipoMascotas",nativeQuery = true)
    List<Map<String, Object>> CitasTipoMascotas();

}
