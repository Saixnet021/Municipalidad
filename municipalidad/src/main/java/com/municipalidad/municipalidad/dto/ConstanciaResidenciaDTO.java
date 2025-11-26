package com.municipalidad.municipalidad.dto;

import com.municipalidad.municipalidad.entity.ConstanciaResidencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ConstanciaResidenciaDTO {
    private Long id;
    private Long ciudadanoId;
    private String ciudadanoNombre;
    private String direccion;
    private String motivo;
    private ConstanciaResidencia.Estado estado;

    public ConstanciaResidenciaDTO() {}

    public ConstanciaResidenciaDTO(Long id, Long ciudadanoId, String ciudadanoNombre, String direccion, String motivo, ConstanciaResidencia.Estado estado) {
        this.id = id;
        this.ciudadanoId = ciudadanoId;
        this.ciudadanoNombre = ciudadanoNombre;
        this.direccion = direccion;
        this.motivo = motivo;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCiudadanoId() { return ciudadanoId; }
    public void setCiudadanoId(Long ciudadanoId) { this.ciudadanoId = ciudadanoId; }
    public String getCiudadanoNombre() { return ciudadanoNombre; }
    public void setCiudadanoNombre(String ciudadanoNombre) { this.ciudadanoNombre = ciudadanoNombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public ConstanciaResidencia.Estado getEstado() { return estado; }
    public void setEstado(ConstanciaResidencia.Estado estado) { this.estado = estado; }
}
