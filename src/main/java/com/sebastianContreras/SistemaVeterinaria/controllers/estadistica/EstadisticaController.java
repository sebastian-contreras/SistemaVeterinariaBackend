package com.sebastianContreras.SistemaVeterinaria.controllers.estadistica;

import com.sebastianContreras.SistemaVeterinaria.persistence.estadistica.EstadisticaDAO;
import com.sebastianContreras.SistemaVeterinaria.repositories.PersonasRepository;
import com.sebastianContreras.SistemaVeterinaria.repositories.veterinaria.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/estadistica")
public class EstadisticaController {
    @Autowired
    private EstadisticaDAO estadisticaDAO;
    @GetMapping("/mascota")
    public ResponseEntity<?> cantidadClaseMascota(){
        List<Map<String, Object>> cantidadClaseMascota = estadisticaDAO.cantidadClaseMascota();
        List<Map<String, Object>> sexoMascota = estadisticaDAO.sexoMascota();
        List<Map<String, Object>> CitasTipoMascotas = estadisticaDAO.CitasTipoMascotas();
        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("cantidadClaseMascota", cantidadClaseMascota);
        combinedData.put("sexoMascota", sexoMascota);
        combinedData.put("citasTipoMascotas", CitasTipoMascotas);
        return ResponseEntity.ok(combinedData);
    }
    @GetMapping("/ganancia")
    public ResponseEntity<?> MontoTotales(){
        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("GananciaAnuales", estadisticaDAO.MontoTotales());
        combinedData.put("GananciaMensuales", estadisticaDAO.MontoTotalesMes());

        return ResponseEntity.ok(combinedData);
    }
    @GetMapping("/gananciavet")
    public ResponseEntity<?> MontoVetTotales(){
        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("GananciaAnuales", estadisticaDAO.MontoVetTotales());
        combinedData.put("GananciaMensuales", estadisticaDAO.MontoVetMes());

        return ResponseEntity.ok(combinedData);
    }
    @GetMapping("/gananciavet/{dni}")
    public ResponseEntity<?> MontoVetTotales(@PathVariable String dni){
        Map<String, Object> combinedData = new HashMap<>();
        combinedData.put("GananciaAnuales", estadisticaDAO.MontoVetTotales(dni));
        combinedData.put("GananciaMensuales", estadisticaDAO.MontoVetMes(dni));
        return ResponseEntity.ok(combinedData);
    }
    @GetMapping("/topvet")
    public ResponseEntity<?> TopVeterinarios(){
        return ResponseEntity.ok(estadisticaDAO.TopVeterinarios());
    }

}
