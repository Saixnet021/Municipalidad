package com.municipalidad.municipalidad.dto;

import com.municipalidad.municipalidad.entity.MesaDePartes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MesaDePartesDTO {
    private Long id;
    private Long ciudadanoId;
    private String ciudadanoNombre;
    private String asunto;
    private String descripcion;
    private String archivoAdjunto;
    private MesaDePartes.Estado estado;

    public MesaDePartesDTO() {}

    public MesaDePartesDTO(Long id, Long ciudadanoId, String ciudadanoNombre, String asunto, String descripcion, String archivoAdjunto, MesaDePartes.Estado estado) {
        this.id = id;
        this.ciudadanoId = ciudadanoId;
        this.ciudadanoNombre = ciudadanoNombre;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.archivoAdjunto = archivoAdjunto;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCiudadanoId() { return ciudadanoId; }
    public void setCiudadanoId(Long ciudadanoId) { this.ciudadanoId = ciudadanoId; }
    public String getCiudadanoNombre() { return ciudadanoNombre; }
    public void setCiudadanoNombre(String ciudadanoNombre) { this.ciudadanoNombre = ciudadanoNombre; }
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getArchivoAdjunto() { return archivoAdjunto; }
    public void setArchivoAdjunto(String archivoAdjunto) { this.archivoAdjunto = archivoAdjunto; }
    public MesaDePartes.Estado getEstado() { return estado; }
    public void setEstado(MesaDePartes.Estado estado) { this.estado = estado; }
}
