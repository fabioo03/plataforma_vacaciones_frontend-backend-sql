package com.example.plataforma_vacaciones.percistence.entities;
import javax.persistence.*;
@Entity
@Table(name = "Usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "id_documento")
    private Long usuarioid;
    @OneToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id_domicilio")
    private DomicilioEntity domicilio; // conectado a domicilio (la direccion)

    @OneToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id_contrato")
    private ContratoEntity contrato; // conectado a contrato

    @Column(name = "tipo_documento")
    private String tipodocumento;

    @Column(name = "Primer_nombre")
    private String primernombre;

    @Column(name = "segundo_nombre")
    private String segundonombre;

    @Column(name = "primer_apellido")
    private String primerapellido;

    @Column(name = "segundo_apellido")
    private String segundoapellido;

    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;

    @Column(name = "apodo_usuario")
    private String apodousuario;

    @Column(name = "contrasena")
    private String contrasena;

    public UsuarioEntity(){

    }

    public UsuarioEntity(Long id){
        this.usuarioid = id;
    }

    public Long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public DomicilioEntity getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioEntity domicilio) {
        this.domicilio = domicilio;
    }

    public ContratoEntity getContrato() {
        return contrato;
    }

    public void setContrato(ContratoEntity contrato) {
        this.contrato = contrato;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApodousuario() {
        return apodousuario;
    }

    public void setApodousuario(String apodousuario) {
        this.apodousuario = apodousuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }
}