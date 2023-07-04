package com.example.plataforma_vacaciones.percistence.entities;
import javax.persistence.*;

@Entity
@Table(name = "estado")
public class EstadoEntityEliminar {
    @Id
    @Column(name = "id_estado")
    private Long estadosid;

    @Column(name = "descripcion")
    private String descripcion;

    public Long getEstadosid() {
        return estadosid;
    }

    public void setEstadosid(Long estadosid) {
        this.estadosid = estadosid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
