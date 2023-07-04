package com.example.plataforma_vacaciones.percistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "Domicilio")

public class DomicilioEntity { // direccion

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private Long domicilioid;
    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private String numero;
    @Column(name = "barrio")
    private String barrio;

    public Long getDomicilioid() {
        return domicilioid;
    }
    public void setDomicilioid(Long domicilioid) {
        this.domicilioid = domicilioid;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}
