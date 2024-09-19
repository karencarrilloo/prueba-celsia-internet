package com.celsia.test.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author
 */
@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "servicio")
    private String servicio;

    @Column(name = "fechainicio")
    private LocalDateTime fechaInicio;

    @Column(name = "ultimafacturacion")
    private LocalDateTime ultimaFacturacion;

    @Column(name = "ultimopago")
    private Integer ultimoPago;

    @ManyToOne
    @JoinColumn(name = "identificacion", insertable = false, updatable = false)
    private Cliente cliente;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getUltimaFacturacion() {
        return ultimaFacturacion;
    }

    public void setUltimaFacturacion(LocalDateTime ultimaFacturacion) {
        this.ultimaFacturacion = ultimaFacturacion;
    }

    public Integer getUltimoPago() {
        return ultimoPago;
    }

    public void setUltimoPago(Integer ultimoPago) {
        this.ultimoPago = ultimoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
