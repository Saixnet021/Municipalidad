package com.municipalidad.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateLicenciaRequest {
    private String negocio;
    private String ruc;
    private String direccion;
    private String representante;
}
