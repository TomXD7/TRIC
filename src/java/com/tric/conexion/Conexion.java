package com.tric.conexion;
import java.sql.Connection;

public interface Conexion {

 public void conectar();

 public Connection getConexion();

 public void desconectar();
}

