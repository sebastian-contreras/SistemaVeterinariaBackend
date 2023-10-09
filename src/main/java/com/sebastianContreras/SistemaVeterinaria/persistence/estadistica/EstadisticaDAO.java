package com.sebastianContreras.SistemaVeterinaria.persistence.estadistica;

import com.sebastianContreras.SistemaVeterinaria.repositories.PersonasRepository;
import com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EstadisticaDAO {
    @Autowired
    private MascotasRepository mascotasRepository;
    @Autowired
    private PersonasRepository personasRepository;
    //ESTADISTICAS MASCOTAS
    public List<Map<String, Object>> cantidadClaseMascota(){
        return mascotasRepository.cantidadClaseMascota();
    }
    public List<Map<String, Object>> sexoMascota(){
        return mascotasRepository.sexoMascota();
    }
    public List<Map<String, Object>> CitasTipoMascotas(){
        return mascotasRepository.CitasTipoMascotas();
    }

    //ESTADISTICAS VETERINARIOS

    public List<Map<String, Object>> MontoVetTotales(){
        return personasRepository.MontoVetTotales();
    }
    public List<Map<String, Object>> MontoVetMes(){
        return personasRepository.MontoVetMes();
    }

    public Map<String, Object> MontoVetTotales(String dni){
        return personasRepository.MontoVetTotales(dni);
    }
    public Map<String, Object> MontoVetMes(String dni){
        return personasRepository.MontoVetMes(dni);
    }
    public List<Map<String, Object>> TopVeterinarios(){
        return personasRepository.TopVeterinarios();
    }
}
