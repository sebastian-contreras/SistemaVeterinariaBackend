package com.sebastianContreras.SistemaVeterinaria.controllers.auth;

import com.sebastianContreras.SistemaVeterinaria.models.auth.AuthResponse;
import com.sebastianContreras.SistemaVeterinaria.models.auth.AuthenticationRequest;
import com.sebastianContreras.SistemaVeterinaria.models.auth.RegisterRequest;
import com.sebastianContreras.SistemaVeterinaria.payload.MessageResponse;
import com.sebastianContreras.SistemaVeterinaria.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        if (authService.register((request)).getToken() != null) {
            return ResponseEntity.ok(authService.register(request));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("No se pudo crear la credencial"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        AuthResponse login = authService.authenticate(request);
        return ResponseEntity.ok(login);
    }
}
