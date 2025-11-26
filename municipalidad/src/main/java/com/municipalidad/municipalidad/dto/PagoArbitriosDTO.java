package com.municipalidad.municipalidad.dto;

import com.municipalidad.municipalidad.entity.PagoArbitrios;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

public class PagoArbitriosDTO {
    private Long id;
    private Long ciudadanoId;
    private String ciudadanoNombre;
    private String tipo;
    private BigDecimal monto;
    private PagoArbitrios.EstadoPago estadoPago;

    public PagoArbitriosDTO() {}

    public PagoArbitriosDTO(Long id, Long ciudadanoId, String ciudadanoNombre, String tipo, BigDecimal monto, PagoArbitrios.EstadoPago estadoPago) {
        this.id = id;
        this.ciudadanoId = ciudadanoId;
        this.ciudadanoNombre = ciudadanoNombre;
        this.tipo = tipo;
        this.monto = monto;
        this.estadoPago = estadoPago;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCiudadanoId() { return ciudadanoId; }
    public void setCiudadanoId(Long ciudadanoId) { this.ciudadanoId = ciudadanoId; }
    public String getCiudadanoNombre() { return ciudadanoNombre; }
    public void setCiudadanoNombre(String ciudadanoNombre) { this.ciudadanoNombre = ciudadanoNombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public PagoArbitrios.EstadoPago getEstadoPago() { return estadoPago; }
    public void setEstadoPago(PagoArbitrios.EstadoPago estadoPago) { this.estadoPago = estadoPago; }
}
