package com.municipalidad.municipalidad.controller;

import com.municipalidad.municipalidad.dto.CreateMesaDePartesRequest;
import com.municipalidad.municipalidad.dto.MesaDePartesDTO;
import com.municipalidad.municipalidad.service.MesaDePartesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mesa-partes")
@RequiredArgsConstructor
public class MesaDePartesController {

    private final MesaDePartesService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MesaDePartesDTO> create(@ModelAttribute CreateMesaDePartesRequest request) throws IOException {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MesaDePartesDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/mis-tramites")
    public ResponseEntity<List<MesaDePartesDTO>> getMyRequests() {
        return ResponseEntity.ok(service.getMyRequests());
    }
}
