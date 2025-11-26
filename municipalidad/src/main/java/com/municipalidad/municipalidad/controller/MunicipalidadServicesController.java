package com.municipalidad.municipalidad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/municipalidad")
public class MunicipalidadServicesController {

    // Mesa de Partes Virtual
    @PostMapping("/mesa-de-partes")
    public ResponseEntity<String> crearMesaDePartes() {
        // Implementación pendiente
        return ResponseEntity.ok("Mesa de Partes Virtual creada correctamente");
    }

    // Solicitud de Constancia de Residencia
    @PostMapping("/constancia-residencia")
    public ResponseEntity<String> solicitarConstanciaResidencia() {
        // Implementación pendiente
        return ResponseEntity.ok("Constancia de Residencia solicitada correctamente");
    }

    // Emisión de Licencias de Funcionamiento
    @PostMapping("/licencia-funcionamiento")
    public ResponseEntity<String> emitirLicenciaFuncionamiento() {
        // Implementación pendiente
        return ResponseEntity.ok("Licencia de Funcionamiento emitida correctamente");
    }

    // Pago de Arbitrios Municipales
    @PostMapping("/pago-arbitrios")
    public ResponseEntity<String> pagarArbitrios() {
        // Implementación pendiente
        return ResponseEntity.ok("Pago de Arbitrios Municipales realizado correctamente");
    }
}
