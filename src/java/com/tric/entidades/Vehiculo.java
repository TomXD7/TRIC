package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "vehiculo")
public class Vehiculo {
    @PrimaryKey
    @AutoIncrement
    private Integer idvehiculo;
    private Integer idtipovehiculo;
    @NotNull
    private String modelo;
    private Integer numero_pasajeros;
    @NotNull
    private String color;
    @NotNull
    private String placa;
    @NotNull
    private double precio;
    @NotNull
    private String marca;

    public Vehiculo() {
    }

    public Vehiculo(Integer idvehiculo, Integer idtipovehiculo, String modelo, Integer numero_pasajeros, String color, String placa, double precio, String marca) {
        this.idvehiculo = idvehiculo;
        this.idtipovehiculo = idtipovehiculo;
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

    public Integer getIdtipovehiculo() {
        return idtipovehiculo;
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

    public double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setIdvehiculo(Integer idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public void setIdtipovehiculo(Integer idtipovehiculo) {
        this.idtipovehiculo = idtipovehiculo;
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

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
