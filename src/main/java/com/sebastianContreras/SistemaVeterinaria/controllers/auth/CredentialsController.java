package com.sebastianContreras.SistemaVeterinaria.controllers.auth;

import com.sebastianContreras.SistemaVeterinaria.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CredentialsController {
    @Autowired
    private AuthService authService;

    @GetMapping("/hascredential/{dni}")
    public ResponseEntity<Boolean> hascredential(@PathVariable String dni){
        return ResponseEntity.ok(authService.hasCredentials((dni)));
    }

}
