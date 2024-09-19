package com.celsia.test.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author
 */
@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "tipoidentificacion")
    private String tipoIdentificacion;

    @Column(name = "fechanacimiento")
    private LocalDateTime fechaNacimiento;

    @Column(name = "numerocelular")
    private String numeroCelular;
    
    @Column(name = "correoelectronico")
    private String correoElectronico;
    
//    @OneToMany(mappedBy = "cliente")
//    private List<Servicio> servicios;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

//    public List<Servicio> getServicios() {
//        return servicios;
//    }
//
//    public void setServicios(List<Servicio> servicios) {
//        this.servicios = servicios;
//    }
    
}
