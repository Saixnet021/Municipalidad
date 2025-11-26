package com.municipalidad.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateConstanciaRequest {
    private String direccion;
    private String motivo;
}
