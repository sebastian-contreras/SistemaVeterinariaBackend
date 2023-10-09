package com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Citas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitasRepository extends CrudRepository<Citas,Integer> {
    List<Citas> findByVeterinarioDni(String dni);
    List<Citas> findByEstado(Boolean estado);
//    List<Citas> findByIdMascotasAndEstado(Integer id,Boolean estado);
    @Query(value = "SELECT c.id_cita,c.id_mascotas,c.veterinario_dni,c.fecha,c.consultorio,c.monto,c.estado,c.titulo,c.descripcion,c.imagenes from citas as c WHERE c.id_mascotas =?1 AND c.estado=?2", nativeQuery = true)
    List<Citas> findByCitasPendientesMascota(Integer id,Boolean estado);

    @Query(value = "SELECT c.id_cita,c.id_mascotas,c.veterinario_dni,c.fecha,c.consultorio,c.monto,c.estado,c.titulo,c.descripcion,c.imagenes FROM \n" +
            "personas as p JOIN mascotas as m ON p.dni = m.dueno_dni\n" +
            "JOIN citas as c ON c.id_mascotas=m.id_mascotas where p.dni=?1",nativeQuery = true)
    List<Citas> findCitasByCliente(String dni);
    @Query(value = "SELECT c.id_cita,c.id_mascotas,c.veterinario_dni,c.fecha,c.consultorio,c.monto,c.estado,c.titulo,c.descripcion,c.imagenes FROM \n" +
            "personas as p JOIN mascotas as m ON p.dni = m.dueno_dni\n" +
            "JOIN citas as c ON c.id_mascotas=m.id_mascotas where p.dni=?1 AND c.estado=0",nativeQuery = true)
    List<Citas> findCitasByClientePendiente(String dni);




}
