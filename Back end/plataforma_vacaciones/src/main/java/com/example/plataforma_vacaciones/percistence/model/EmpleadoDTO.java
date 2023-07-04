package com.example.plataforma_vacaciones.percistence.model;

import java.math.BigInteger;

public class EmpleadoDTO {
    private Integer id_empleado; // 0
    private BigInteger id_documento;// 1
    private String tipo_documento;//2
    private String Primer_nombre;//3
    private String segundo_nombre;//4
    private String primer_apellido;//5
    private String segundo_apellido;//6
    private String correo;//7
    private String apodo_usuario; //8
    private String contraseña;//9
    private String nombre_equipo;//10

    public EmpleadoDTO(Integer id_empleado, BigInteger id_documento, String tipo_documento, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String correo, String apodo_usuario, String contraseña, String nombre_equipo) {
        this.id_empleado = id_empleado;
        this.id_documento = id_documento;
        this.tipo_documento = tipo_documento;
        this. Primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.correo = correo;
        this.apodo_usuario = apodo_usuario;
        this.contraseña = contraseña;
        this.nombre_equipo = nombre_equipo;
    }

    public EmpleadoDTO(Integer id_empleado, BigInteger id_documento, String tipo_documento, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String correo, String apodo_usuario, String contraseña, String nombre_equipo, String s, String s1) {
    }

    //  public EmpleadoDTO(Integer id_empleado, BigInteger id_documento, String tipo_documento, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String correo, String apodo_usuario, String contraseña, String nombre_equipo, String s, String s1) {
   // }

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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getPrimer_nombre() {
        return Primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        Primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApodo_usuario() {
        return apodo_usuario;
    }

    public void setApodo_usuario(String apodo_usuario) {
        this.apodo_usuario = apodo_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }
}

