package com.municipalidad.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateArbitrioRequest {
    private Long ciudadanoId; // Admin assigns to citizen
    private String tipo;
    private BigDecimal monto;
}
