package com.sebastianContreras.SistemaVeterinaria.services.auth;

import com.sebastianContreras.SistemaVeterinaria.config.JwtService;
import com.sebastianContreras.SistemaVeterinaria.entities.Credenciales;
import com.sebastianContreras.SistemaVeterinaria.entities.Personas;
import com.sebastianContreras.SistemaVeterinaria.models.auth.AuthResponse;
import com.sebastianContreras.SistemaVeterinaria.models.auth.AuthenticationRequest;
import com.sebastianContreras.SistemaVeterinaria.models.auth.RegisterRequest;
import com.sebastianContreras.SistemaVeterinaria.models.auth.UserTokenResponse;
import com.sebastianContreras.SistemaVeterinaria.repositories.CredencialesRepository;
import com.sebastianContreras.SistemaVeterinaria.repositories.PersonasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CredencialesRepository credencialesRepository;
    private final PersonasRepository personasRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AuthResponse register(RegisterRequest request) {

        Optional<Personas> personasbus = personasRepository.findById(request.getDni());
        Optional<Credenciales> credencialbus = credencialesRepository.findById(request.getDni());
        if (personasbus.isPresent() && credencialbus.isEmpty()) {
            var credencial = Credenciales.builder()
                    .personasDni(request.getDni())
                    .usuario(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .rol(request.getPerfilRol())
                    .personas(personasbus.get())
                    .build();
            credencialesRepository.save(credencial);
            var claim = new HashMap<String, Object>();
            claim.put("dni", credencial.getPersonasDni());
            var token = jwtService.generateToken(claim, credencial);
            return AuthResponse.builder()
                    .username(credencial.getUsername())
                    .dni(credencial.getPersonasDni())
                    .apellido(credencial.getPersonas().getApellido())
                    .nombre(credencial.getPersonas().getNombre())
                    .token(token).build();
        }
        return AuthResponse.builder().build();
    }

    @Override
    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        var user = credencialesRepository.findByUsuario(request.getUsername()).orElseThrow();
        var claim = new HashMap<String, Object>();
        claim.put("dni", user.getPersonasDni());
        var token = jwtService.generateToken(claim, user);
        return AuthResponse.builder().token(token)
                .dni(user.getPersonasDni()).username(user.getUsuario())
                .apellido(user.getPersonas().getApellido())
                .nombre(user.getPersonas().getNombre())
                .rol(user.getRol())
                .build();
    }

    @Override
    public Boolean hasCredentials(String dni) {
        Optional<Credenciales> cred = credencialesRepository.findById(dni);
        if(cred.isPresent()){
            return true;
        }
        return false;
    }
}
