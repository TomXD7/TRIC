
package com.tric.entidades;
import com.tric.anotaciones.*;
import java.math.BigDecimal;
@Entity (table = "vehiculo")
public class Vehiculo {
    @PrimaryKey
    @AutoIncrement
    private Integer idvehiculo;
    @NotNull
    private String modelo;
    private Integer numero_pasajeros;
    @NotNull
    private String color;
    @NotNull
    private String placa;
    @NotNull
    private BigDecimal precio;
    @NotNull
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(Integer idvehiculo, String modelo, Integer numero_pasajeros, String color, String placa, BigDecimal precio, String marca) {
        this.idvehiculo = idvehiculo;
        this.modelo = modelo;
        this.numero_pasajeros = numero_pasajeros;
        this.color = color;
        this.placa = placa;
        this.precio = precio;
        this.marca = marca;
    }

    public Integer getIdvehiculo() {
        return idvehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getNumero_pasajeros() {
        return numero_pasajeros;
    }

    public String getColor() {
        return color;
    }

    public String getPlaca() {
        return placa;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumero_pasajeros(Integer numero_pasajeros) {
        this.numero_pasajeros = numero_pasajeros;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
