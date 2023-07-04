package com.example.plataforma_vacaciones.percistence.entities;
import javax.persistence.*;


@Entity
@Table(name = "Empleado")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id_empleado;

    @OneToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id_documento") // conectado a usuario
    private UsuarioEntity usuario;

    @ManyToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id_equipo") // conectado con el equipo
    private EquipoEntity equipo;

    @ManyToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id_administrador") // conectado con el administrador
    private AdministradorEntity administrador;

    public Long getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public EquipoEntity getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntity equipo) {
        this.equipo = equipo;
    }

    public AdministradorEntity getAdministrador() {
        return administrador;
    }

    public void setAdministrador(AdministradorEntity administrador) {
        this.administrador = administrador;
    }

}


