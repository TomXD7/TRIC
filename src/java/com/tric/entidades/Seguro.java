package com.tric.entidades;
import com.tric.anotaciones.*;
import java.math.BigDecimal;
@Entity (table = "seguro")
public class Seguro {
    @PrimaryKey
    @AutoIncrement
    private Integer idseguro;
    private String nombre;
    private BigDecimal precio;
    private String detalle_servicio;

    public Seguro() {
    }

    public Seguro(Integer idseguro, String nombre, BigDecimal precio, String detalle_servicio) {
        this.idseguro = idseguro;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle_servicio = detalle_servicio;
    }

    public Integer getIdseguro() {
        return idseguro;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getDetalle_servicio() {
        return detalle_servicio;
    }

    public void setIdseguro(Integer idseguro) {
        this.idseguro = idseguro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setDetalle_servicio(String detalle_servicio) {
        this.detalle_servicio = detalle_servicio;
    }
    
    
}
