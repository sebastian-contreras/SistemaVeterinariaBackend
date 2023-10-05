package com.sebastianContreras.SistemaVeterinaria.controllers.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {
    @GetMapping("/secured")
    public ResponseEntity secured(){
        return ResponseEntity.ok("Seguro");
    }
}
