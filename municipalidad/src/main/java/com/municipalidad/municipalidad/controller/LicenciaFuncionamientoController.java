package com.municipalidad.municipalidad.controller;

import com.municipalidad.municipalidad.dto.CreateLicenciaRequest;
import com.municipalidad.municipalidad.dto.LicenciaFuncionamientoDTO;
import com.municipalidad.municipalidad.service.LicenciaFuncionamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/licencias")
@RequiredArgsConstructor
public class LicenciaFuncionamientoController {

    private final LicenciaFuncionamientoService service;

    @PostMapping
    public ResponseEntity<LicenciaFuncionamientoDTO> create(@RequestBody CreateLicenciaRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<LicenciaFuncionamientoDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/mis-tramites")
    public ResponseEntity<List<LicenciaFuncionamientoDTO>> getMyRequests() {
        return ResponseEntity.ok(service.getMyRequests());
    }
}
