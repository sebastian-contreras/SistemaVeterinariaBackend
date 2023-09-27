package com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria.dto.CitasDto;
import com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria.dto.HistoriaDto;
import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Citas;
import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import com.sebastianContreras.SistemaVeterinaria.persistence.IPersonasDAO;
import com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.ICitasDAO;
import com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.IMascotasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.ReplicateScaleFilter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

@RequestMapping("/api")
public class CitasController {
    @Autowired
    private ICitasDAO service;
    @Autowired
    private IMascotasDAO serviceMascota;
    @Autowired
    private IPersonasDAO servicePersonas;
    @GetMapping("/citas")
    public ResponseEntity<?> allCitas(){
        List<Citas> lista = service.todasCitas();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/citas/{dni}")
    public ResponseEntity<?> citasClientes(@PathVariable String dni){
        List <Citas> lista = service.citasByDniCliente(dni);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/citasveterinario/{dni}")
    public ResponseEntity<?> citasVeterinario(@PathVariable String dni){
        List <Citas> lista = service.citasDeVeterinario(dni);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/citaspendiente")
    public ResponseEntity<?> citasPendientes(){
        List <Citas> lista = service.citasPendiente();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/citaspendiente/{dni}")
    public ResponseEntity<?> citasPendientes(@PathVariable String dni){
        List <Citas> lista = service.citasPendientesByCliente(dni);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/citasmascota/{id}")
    public ResponseEntity<?> citasPendientesMascota(@PathVariable Integer id){
        List <Citas> lista = service.citasPendientesByMascota(id);
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/historia/{id}")
    public ResponseEntity<?> historia(@PathVariable Integer id){
        List <Citas> lista = service.historiaMascota(id);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/citas/save")
    public ResponseEntity<?> save(@RequestBody CitasDto newCita) throws URISyntaxException {
        Optional<Personas> veterinarioACargo = servicePersonas.personaByDNI(newCita.getVeterinario());
        Optional<Mascotas> mascotaCita = serviceMascota.encontrarMascotaId(newCita.getMascota());
        if(veterinarioACargo.isPresent() && mascotaCita.isPresent()){
            Citas newCitaPost = Citas.builder()
                    .fecha(newCita.getFecha())
                    .veterinario(veterinarioACargo.get())
                    .mascota(mascotaCita.get())
                    .monto(newCita.getMonto())
                    .estado(false)
                    .consultorio(newCita.getConsultorio())
                    .build();
            service.save(newCitaPost);
            return ResponseEntity.created(new URI("/api/cita/save")).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/historia/createhistoria/{id}")
    public ResponseEntity<?> UpdateHistoria(@PathVariable Integer id,@RequestBody HistoriaDto newHistoria) throws URISyntaxException {
        Optional<Citas> citaFound = service.citaById(id);
        if(citaFound.isPresent()){
            Citas historia = citaFound.get();
            historia.setTitulo(newHistoria.getTitulo());
            historia.setDescripcion(newHistoria.getDescripcion());
            historia.setImagenes(newHistoria.getImagenes());
            historia.setEstado(true);
            service.save(historia);
            return ResponseEntity.ok("Cambios actualizados");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/citaspendiente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(id!=null){
            service.deleteById(id);
        }
        return ResponseEntity.ok("Registro eliminado");
    }
}
