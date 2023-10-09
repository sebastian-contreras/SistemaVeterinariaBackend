package com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria;

import com.sebastianContreras.SistemaVeterinaria.controllers.veterinaria.dto.MascotasDto;
import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import com.sebastianContreras.SistemaVeterinaria.entities.veterinaria.Mascotas;
import com.sebastianContreras.SistemaVeterinaria.persistence.IPersonasDAO;
import com.sebastianContreras.SistemaVeterinaria.persistence.veterinaria.IMascotasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MascotasController {
    @Autowired
    private IMascotasDAO servicio;
    @Autowired
    private IPersonasDAO servicioPersonas;
    @GetMapping(value ="/mascotas",params = {"page"})
    public ResponseEntity<?> todasMascotasPage( @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);

        List<Mascotas> mascotas = servicio.todasMascotas(pageable);
        return ResponseEntity.ok(mascotas);
    }
    @GetMapping("/mascotas")
    public ResponseEntity<?> todasMascotas(){
        List<Mascotas> mascotas = servicio.todasMascotas();
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/mascotas/perfil/{id}")
    public ResponseEntity<?> oneMascota(@PathVariable Integer id){
        Optional<Mascotas> mascota = servicio.encontrarMascotaId(id);
            if(mascota.isPresent()){
            return ResponseEntity.ok(mascota);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/mascotas/{dni}")
    public ResponseEntity<?> todasMascotas(@PathVariable String dni){
        List<Mascotas> mascotas = servicio.mascotasDeDueno(dni);
        return ResponseEntity.ok(mascotas);
    }


    @PostMapping("/mascotas/save")
    public ResponseEntity<?> save(@RequestBody MascotasDto newMascota) throws URISyntaxException {
        Optional<Personas> dueno=servicioPersonas.personaByDNI(newMascota.getDueno());
        if(dueno.isPresent()){
            Mascotas newMascotaPost = Mascotas.builder()
                    .nombre(newMascota.getNombre())
                    .tipo(newMascota.getTipo())
                    .fechaDeNacimiento(newMascota.getFechaDeNacimiento())
                    .dueno(dueno.get())
                    .urlFoto(newMascota.getUrlFoto())
                    .sexo(newMascota.getSexo())
                    .build();
            servicio.save(newMascotaPost);
            return ResponseEntity.created(new URI("/api/mascotas/save")).build();

        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/mascotas/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

        if(id!=null){
            servicio.deleteMascota(id);
        }
        return ResponseEntity.ok("Registro eliminado");
    }
}



