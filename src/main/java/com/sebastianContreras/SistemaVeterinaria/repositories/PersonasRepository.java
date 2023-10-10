package com.sebastianContreras.SistemaVeterinaria.repositories;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PersonasRepository extends CrudRepository<Personas,String>, PagingAndSortingRepository<Personas,String> {
    List<Personas> findByPerfilRol(Roles rol, Pageable pageable);
    List<Personas> findByPerfilRol(Roles rol);



    @Query(value = "select veterinario_dni,nombre,apellido, citas,total from MontoVetTotales",nativeQuery = true)
    List<Map<String, Object>> MontoVetTotales();
    @Query(value = "select veterinario_dni,nombre,apellido, citas,total from MontoVetMes",nativeQuery = true)
    List<Map<String, Object>> MontoVetMes();

    @Query(value = "select veterinario_dni,nombre,apellido, citas,total from MontoVetTotales WHERE veterinario_dni=?1",nativeQuery = true)
    Map<String, Object> MontoVetTotales(String dni);
    @Query(value = "select veterinario_dni,nombre,apellido, citas,total from MontoVetMes WHERE veterinario_dni=?1",nativeQuery = true)
    Map<String, Object> MontoVetMes(String dni);

    @Query(value = "select sum(citas) as 'citas',sum(total) as 'total' from MontoVetTotales",nativeQuery = true)
    Map<String, Object> MontoTotales();
    @Query(value = "select sum(citas) as 'citas',sum(total) as 'total' from MontoVetMes",nativeQuery = true)
    Map<String, Object> MontoTotalesMes();

    @Query(value = "select dni,nombre,apellido,cantidad,monto from TopVeterinarios",nativeQuery = true)
    List<Map<String, Object>> TopVeterinarios();

}
