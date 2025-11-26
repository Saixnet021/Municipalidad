package com.municipalidad.municipalidad.controller;

import com.municipalidad.municipalidad.dto.ConstanciaResidenciaDTO;
import com.municipalidad.municipalidad.dto.CreateConstanciaRequest;
import com.municipalidad.municipalidad.service.ConstanciaResidenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/constancia-residencia")
@RequiredArgsConstructor
public class ConstanciaResidenciaController {

    private final ConstanciaResidenciaService service;

    @PostMapping
    public ResponseEntity<ConstanciaResidenciaDTO> create(@RequestBody CreateConstanciaRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ConstanciaResidenciaDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/mis-tramites")
    public ResponseEntity<List<ConstanciaResidenciaDTO>> getMyRequests() {
        return ResponseEntity.ok(service.getMyRequests());
    }
}
