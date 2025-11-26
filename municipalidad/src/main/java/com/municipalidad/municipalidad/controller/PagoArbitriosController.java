package com.municipalidad.municipalidad.controller;

import com.municipalidad.municipalidad.dto.CreateArbitrioRequest;
import com.municipalidad.municipalidad.dto.PagoArbitriosDTO;
import com.municipalidad.municipalidad.service.PagoArbitriosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/arbitrios")
@RequiredArgsConstructor
public class PagoArbitriosController {

    private final PagoArbitriosService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PagoArbitriosDTO> create(@RequestBody CreateArbitrioRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PagoArbitriosDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/mis-deudas")
    public ResponseEntity<List<PagoArbitriosDTO>> getMyDebts() {
        return ResponseEntity.ok(service.getMyDebts());
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<Void> pay(@PathVariable Long id) {
        service.pay(id);
        return ResponseEntity.ok().build();
    }
}
