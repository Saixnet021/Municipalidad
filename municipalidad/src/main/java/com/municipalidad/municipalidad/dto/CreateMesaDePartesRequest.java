package com.municipalidad.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMesaDePartesRequest {
    private String asunto;
    private String descripcion;
    private MultipartFile archivo;
}
