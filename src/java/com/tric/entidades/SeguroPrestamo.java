package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "seguroprestamo")
public class SeguroPrestamo {
    @PrimaryKey
    private Integer idseguro;
    @PrimaryKey
    private Integer idprestamo;
    @NotNull
    private Integer cantidad;

    public SeguroPrestamo() {
    }

    public SeguroPrestamo(Integer idseguro, Integer idprestamo, Integer cantidad) {
        this.idseguro = idseguro;
        this.idprestamo = idprestamo;
        this.cantidad = cantidad;
    }

    public Integer getIdseguro() {
        return idseguro;
    }

    public Integer getIdprestamo() {
        return idprestamo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setIdseguro(Integer idseguro) {
        this.idseguro = idseguro;
    }

    public void setIdprestamo(Integer idprestamo) {
        this.idprestamo = idprestamo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
