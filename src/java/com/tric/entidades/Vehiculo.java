
package com.tric.entidades;
import com.tric.anotaciones.*;
import java.math.BigDecimal;
@Entity (table = "vehiculo")
public class Vehiculo {
    @PrimaryKey
    @AutoIncrement
    private Integer idvehiculo;
    @NotNull
    private Integer numero_pasajeros;
    @NotNull
    private String placa;
    @NotNull
    private String marca;
    @NotNull
    private String tipo;
    @NotNull
    private String descripcion;
    @NotNull
    private BigDecimal precio;

    public Vehiculo() {
    }

    public Vehiculo(Integer idvehiculo, Integer numero_pasajeros, String placa, String marca, String tipo, String descripcion, BigDecimal precio) {
        this.idvehiculo = idvehiculo;
        this.numero_pasajeros = numero_pasajeros;
        this.placa = placa;
        this.marca = marca;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Integer getNumero_pasajeros() {
        return numero_pasajeros;
    }

    public void setNumero_pasajeros(Integer numero_pasajeros) {
        this.numero_pasajeros = numero_pasajeros;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
}
