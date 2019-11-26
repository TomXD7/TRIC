package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "usuario")
public class Usuario {
    @PrimaryKey
    @NotNull
    private String idusuario;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private String correo;
    @NotNull
    private String telefono;
    @NotNull
    private String contraseña;
    @NotNull
    private Integer idrol;

    public Usuario() {
    }

    public Usuario(String idusuario, String nombres, String apellidos, String correo, String telefono, String contraseña, Integer idrol) {
        this.idusuario = idusuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.idrol = idrol;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }
    
    
}
