package com.sebastianContreras.SistemaVeterinaria.services.auth;


import com.sebastianContreras.SistemaVeterinaria.models.auth.AuthResponse;
import com.sebastianContreras.SistemaVeterinaria.models.auth.AuthenticationRequest;
import com.sebastianContreras.SistemaVeterinaria.models.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthenticationRequest request);

}
