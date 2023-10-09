package com.sebastianContreras.SistemaVeterinaria.controllers.personas;

import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.entities.enumeraciones.Roles;
import com.sebastianContreras.SistemaVeterinaria.persistence.impl.PersonasDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class PersonasController {
    @Autowired
    private PersonasDAO servicio;
    @GetMapping(value = "/clientes",params = {"page"})
    public ResponseEntity<?> findClientes( @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        List<Personas> personas = servicio.todosClientes(pageable);
        return ResponseEntity.ok(personas);
    }
    @GetMapping("/clientes")
    public ResponseEntity<?> findClientes(){
        List<Personas> listaPersonas = servicio.todosClientes();
        return ResponseEntity.ok(listaPersonas);
    }
    @GetMapping("/empleados")
    public ResponseEntity<?> findEmpleados(){
        List<Personas> listaPersonas = servicio.todosEmpleados();

        return ResponseEntity.ok(listaPersonas);
    }
    @GetMapping("/veterinarios")
    public ResponseEntity<?> findVeterinarios(){
        List<Personas> listaPersonas = servicio.todosVeterinarios();
        return ResponseEntity.ok(listaPersonas);
    }
    @GetMapping("/clientes/{dni}")
    public ResponseEntity<?> findOneClientes(@PathVariable String dni){
        Optional<Personas> persona = servicio.personaByDNI(dni);
        if(persona.isPresent()){
            return ResponseEntity.ok(persona);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/empleados/{dni}")
    public ResponseEntity<?> findOneEmpleados(@PathVariable String dni){
        Optional<Personas> persona = servicio.personaByDNI(dni);
        if(persona.isPresent()){
            return ResponseEntity.ok(persona);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/veterinarios/{dni}")
    public ResponseEntity<?> findOneVeterinarios(@PathVariable String dni){
        Optional<Personas> persona = servicio.personaByDNI(dni);
        if(persona.isPresent()){
            return ResponseEntity.ok(persona);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/persona/save")
    public ResponseEntity<?> save(@RequestBody Personas newPersona) throws URISyntaxException {
        if(newPersona.getPerfilRol() == Roles.USUARIO){
            newPersona.setMatricula(null);
        }
        servicio.save(newPersona);
        return ResponseEntity.created(new URI("/api/persona/save")).build();
    }

    @DeleteMapping("/persona/{dni}")
    public ResponseEntity<?> delete(@PathVariable String dni){
        if(dni!=null){
            servicio.deleteByDNI(dni);
        }
        return ResponseEntity.ok("Registro eliminado");
    }
}
