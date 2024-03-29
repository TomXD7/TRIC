package com.tric.entidades;
import com.tric.anotaciones.*;
import java.math.BigDecimal;
@Entity (table = "mejora")
public class Mejora {
    @PrimaryKey
    @AutoIncrement
    private Integer idmejora;
    private String nombre;
    private BigDecimal precio;
    private String detalle_servicio;

    public Mejora() {
    }

    public Mejora(Integer idmejora, String nombre, BigDecimal precio, String detalle_servicio) {
        this.idmejora = idmejora;
        this.nombre = nombre;
        this.precio = precio;
        this.detalle_servicio = detalle_servicio;
    }

    public Integer getIdmejora() {
        return idmejora;
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

    public void setIdmejora(int idmejora) {
        this.idmejora = idmejora;
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
