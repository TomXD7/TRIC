package com.tric.entidades;
import com.tric.anotaciones.*;
import java.sql.Timestamp;
@Entity (table = "prestamo")
public class Prestamo {
    @PrimaryKey
    @AutoIncrement
    private Integer idprestamo;
    @NotNull
    private String reserva; //convertir a date
    @NotNull
    private Timestamp fecha_inicio; //convertir a date
    @NotNull
    private Timestamp fecha_fin; //convertir a date
    private String idcliente;
    private Integer idvehiculo;
    private Integer idmejora;
    private Integer idproducto;

    public Prestamo() {
    }

    public Prestamo(Integer idprestamo, String reserva, Timestamp fecha_inicio, Timestamp fecha_fin, String idcliente, Integer idvehiculo, Integer idmejora, Integer idproducto) {
        this.idprestamo = idprestamo;
        this.reserva = reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.idcliente = idcliente;
        this.idvehiculo = idvehiculo;
        this.idmejora = idmejora;
        this.idproducto = idproducto;
    }

    public Integer getIdprestamo() {
        return idprestamo;
    }

    public String getReserva() {
        return reserva;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }


    public String getIdcliente() {
        return idcliente;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public Integer getIdmejora() {
        return idmejora;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdprestamo(Integer idprestamo) {
        this.idprestamo = idprestamo;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public void setIdmejora(Integer idmejora) {
        this.idmejora = idmejora;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }
    
    
}
