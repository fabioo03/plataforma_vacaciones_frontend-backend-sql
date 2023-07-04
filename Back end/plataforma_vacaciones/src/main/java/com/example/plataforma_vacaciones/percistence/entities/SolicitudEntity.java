package com.example.plataforma_vacaciones.percistence.entities;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Solicitud")
public class SolicitudEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long solicitudid;
    @ManyToOne
    @JoinColumn(name = "id_empleado") // conectado con el empleado
    private EmpleadoEntity empleado;

    @Column(name = "estado_supervisor")
    private String estadossupervisor;
    @Column(name = "estado_administrador")
    private String estadosadministrador;
    @Column(name = "fecha_solicitud")
    private LocalDate fechasolicitud;

    @Column(name = "fecha_inicio")
    private LocalDate fechainicio;

    @Column(name = "fecha_fin")
    private LocalDate fechafin;

    @Column(name = "diassolicitados")
    private int diassolicitados;

    @Column(name = "nota_solicitud")
    private String notasolicitud;

    @Column(name = "fecha_control_estado")
    private LocalDate fechacontrolestado;

    public Long getSolicitudid() {
        return solicitudid;
    }

    public void setSolicitudid(Long solicitudid) {
        this.solicitudid = solicitudid;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechasolicitud() {
        return fechasolicitud;
    }

    public void setFechasolicitud(LocalDate fechasolicitud) {
        this.fechasolicitud = fechasolicitud;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public LocalDate getFechafin() {
        return fechafin;
    }

    public void setFechafin(LocalDate fechafin) {
        this.fechafin = fechafin;
    }

    public String getNotasolicitud() {
        return notasolicitud;
    }

    public void setNotasolicitud(String notasolicitud) {
        this.notasolicitud = notasolicitud;
    }

    public LocalDate getFechacontrolestado() {
        return fechacontrolestado;
    }

    public void setFechacontrolestado(LocalDate fechacontrolestado) {
        this.fechacontrolestado = fechacontrolestado;
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

    public int getDiassolicitados() {
        return diassolicitados;
    }

    public void setDiassolicitados(int diassolicitados) {
        this.diassolicitados = diassolicitados;
    }
}
