package com.example.plataforma_vacaciones.percistence.entities;
import javax.persistence.*;

@Entity
@Table(name = "Equipo")

public class EquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private int equipoid;

    @ManyToOne
    @JoinColumn(name = "id_documento")
    private UsuarioEntity usuario;

    @Column(name = "nombre_equipo")
    private String nombreequipo;


    public int getEquipoid() {
        return equipoid;
    }

    public void setEquipoid(int equipoid) {
        this.equipoid = equipoid;
    }

    public String getNombre() {
        return nombreequipo;
    }

    public void setNombre(String nombreequipo) {
        this.nombreequipo = nombreequipo;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getNombreequipo() {
        return nombreequipo;
    }

    public void setNombreequipo(String nombreequipo) {
        this.nombreequipo = nombreequipo;
    }

}
