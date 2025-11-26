package com.municipalidad.municipalidad.dto;

import com.municipalidad.municipalidad.entity.LicenciaFuncionamiento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LicenciaFuncionamientoDTO {
    private Long id;
    private Long ciudadanoId;
    private String negocio;
    private String ruc;
    private String direccion;
    private String representante;
    private LicenciaFuncionamiento.Estado estado;

    public LicenciaFuncionamientoDTO() {}

    public LicenciaFuncionamientoDTO(Long id, Long ciudadanoId, String negocio, String ruc, String direccion, String representante, LicenciaFuncionamiento.Estado estado) {
        this.id = id;
        this.ciudadanoId = ciudadanoId;
        this.negocio = negocio;
        this.ruc = ruc;
        this.direccion = direccion;
        this.representante = representante;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCiudadanoId() { return ciudadanoId; }
    public void setCiudadanoId(Long ciudadanoId) { this.ciudadanoId = ciudadanoId; }
    public String getNegocio() { return negocio; }
    public void setNegocio(String negocio) { this.negocio = negocio; }
    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getRepresentante() { return representante; }
    public void setRepresentante(String representante) { this.representante = representante; }
    public LicenciaFuncionamiento.Estado getEstado() { return estado; }
    public void setEstado(LicenciaFuncionamiento.Estado estado) { this.estado = estado; }
}
