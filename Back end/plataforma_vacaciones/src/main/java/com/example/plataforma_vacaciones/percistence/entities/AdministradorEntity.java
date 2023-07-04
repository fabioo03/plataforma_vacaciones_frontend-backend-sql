package com.example.plataforma_vacaciones.percistence.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Administrador")
public class AdministradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long administradorid;

    @OneToOne
    @JoinColumn(name = "id_documento") // conectado a usuario
    private UsuarioEntity usuario;

    public Long getAdministradorid() {
        return administradorid;
    }

    public void setAdministradorid(Long administradorid) {
        this.administradorid = administradorid;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    public AdministradorEntity(){

    }
    public AdministradorEntity(Long id){
        this.administradorid = id;
    }

}
