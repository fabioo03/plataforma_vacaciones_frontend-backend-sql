package com.example.plataforma_vacaciones.percistence.entities;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Contrato")
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private int contratoid;

    @Column(name = "tipo_contrato")
    private String tipocontrato;

    @Column(name = "estado_contrato")
    private String estadocontrato;

    @Column(name = "estado_empleado")
    private String estadoempleado;

    @Column(name = "fecha_ingreso")
    private LocalDate  fechaingreso;

    @Column(name = "fecha_retiro")
    private LocalDate fecharetiro;


    public int getContratoid() {
        return contratoid;
    }

    public void setContratoid(int contratoid) {
        this.contratoid = contratoid;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public String getEstadocontrato() {
        return estadocontrato;
    }

    public void setEstadocontrato(String estadocontrato) {
        this.estadocontrato = estadocontrato;
    }

    public String getEstadoempleado() {
        return estadoempleado;
    }

    public void setEstadoempleado(String estadoempleado) {
        this.estadoempleado = estadoempleado;
    }

    public LocalDate getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(LocalDate fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public LocalDate getFecharetiro() {
        return fecharetiro;
    }

    public void setFecharetiro(LocalDate fecharetiro) {
        this.fecharetiro = fecharetiro;
    }
}
