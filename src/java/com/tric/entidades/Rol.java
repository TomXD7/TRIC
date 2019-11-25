package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "rol")
public class Rol {
    @PrimaryKey
    @AutoIncrement
    private Integer idrol;
    @NotNull
    private String rol;

    public Rol() {
    }

    public Rol(Integer idrol, String rol) {
        this.idrol = idrol;
        this.rol = rol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
