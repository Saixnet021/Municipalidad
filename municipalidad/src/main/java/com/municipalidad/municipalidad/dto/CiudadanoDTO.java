package com.municipalidad.municipalidad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadanoDTO {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String role;
}
