package com.example.plataforma_vacaciones.percistence.model;
import java.math.BigInteger;
import java.time.LocalDate;

public class SolicitudDTO {
 //  SELECT   s.id_empleado , e.id_documento , s.id_estado_supervisor, s.id_estado_administrador,s.fecha_control_estado FROM solicitud as s
    private Integer id_empleado;
    private BigInteger id_documento;
    private String estadossupervisor;
    private String estadosadministrador;
    private LocalDate fechacontrolestado;
    private int diassolicitados;

    public SolicitudDTO(Integer id_empleado, BigInteger id_documento, String estadossupervisor, String estadosadministrador, LocalDate fechacontrolestado, int diassolicitados) {
        this.id_empleado = id_empleado;
        this.id_documento = id_documento;
        this.estadossupervisor = estadossupervisor;
        this.estadosadministrador = estadosadministrador;
        this.fechacontrolestado = fechacontrolestado;
        this.diassolicitados = diassolicitados;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public BigInteger getId_documento() {
        return id_documento;
    }

    public void setId_documento(BigInteger id_documento) {
        this.id_documento = id_documento;
    }

    public String getEstadossupervisor() {
        return estadossupervisor;
    }

    public void setEstadossupervisor(String estadossupervisor) {
        this.estadossupervisor = estadossupervisor;
    }

    public String getEstadosadministrador() {
        return estadosadministrador;
    }

    public void setEstadosadministrador(String estadosadministrador) {
        this.estadosadministrador = estadosadministrador;
    }

    public LocalDate getFechacontrolestado() {
        return fechacontrolestado;
    }

    public void setFechacontrolestado(LocalDate fechacontrolestado) {
        this.fechacontrolestado = fechacontrolestado;
    }

    public int getDiassolicitados() {
        return diassolicitados;
    }

    public void setDiassolicitados(int diassolicitados) {
        this.diassolicitados = diassolicitados;
    }
}
