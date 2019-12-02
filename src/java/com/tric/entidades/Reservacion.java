package com.tric.entidades;
import com.tric.anotaciones.*;
    import java.sql.Timestamp;
@Entity (table = "reservacion")
public class Reservacion {
    @PrimaryKey
    @AutoIncrement
    private Integer idreservacion;
    @NotNull
    private Timestamp fecha_inicio; 
    @NotNull
    private Timestamp fecha_fin;
    @NotNull
    private String agencia;
    private String idusuario;
    private Integer idvehiculo;
    private Integer idmejora;
    private Integer idproducto;

    public Reservacion() {
    }

    public Reservacion(Integer idreservacion, Timestamp fecha_inicio, Timestamp fecha_fin, String agencia, String idusuario, Integer idvehiculo, Integer idmejora, Integer idproducto) {
        this.idreservacion = idreservacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.agencia = agencia;
        this.idusuario = idusuario;
        this.idvehiculo = idvehiculo;
        this.idmejora = idmejora;
        this.idproducto = idproducto;
    }

    public Integer getIdreservacion() {
        return idreservacion;
    }

    public void setIdreservacion(Integer idreservacion) {
        this.idreservacion = idreservacion;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Integer getIdmejora() {
        return idmejora;
    }

    public void setIdmejora(Integer idmejora) {
        this.idmejora = idmejora;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }
    
    

}