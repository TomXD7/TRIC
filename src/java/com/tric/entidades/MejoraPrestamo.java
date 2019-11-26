package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "mejoraprestamo")
public class MejoraPrestamo {
    @PrimaryKey
    private Integer idmejora;
    @PrimaryKey
    private Integer idprestamo;
    @NotNull
    private Integer cantidad;

    public MejoraPrestamo() {
    }

    public MejoraPrestamo(Integer idmejora, Integer idprestamo, Integer cantidad) {
        this.idmejora = idmejora;
        this.idprestamo = idprestamo;
        this.cantidad = cantidad;
    }

    public Integer getIdmejora() {
        return idmejora;
    }

    public Integer getIdprestamo() {
        return idprestamo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setIdmejora(Integer idmejora) {
        this.idmejora = idmejora;
    }

    public void setIdprestamo(Integer idprestamo) {
        this.idprestamo = idprestamo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
