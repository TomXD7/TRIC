/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tric.control;

import com.tric.conexion.Conexion;
import com.tric.conexion.ConexionPool;
import com.tric.entidades.Vehiculo;
import com.tric.operaciones.Operaciones;
import com.tric.utilerias.Tabla;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leyss
 */
public class Vehiculos extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
            }
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();

                String sql = "";
                if (request.getParameter("txtBusqueda") != null) {
                    sql = "select * from vehiculo where nombre like ?";
                } else {
                    sql = "select * from vehiculo";
                }
                String[][] vehiculos = null;
                if (request.getParameter("txtBusqueda") != null) {
                    List<Object> params = new ArrayList<>();
                    params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                    vehiculos = Operaciones.consultar(sql, params);
                } else {
                    vehiculos = Operaciones.consultar(sql, null);
                }
                //declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                    "ID Vehiculo",
                    "Modelo",
                    "Numero de pasajeros",
                    "Color",
                    "Placa",
                    "Precio",
                    "Marca"
                };
                //variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(vehiculos, //array que contiene los datos
                        "50%", //ancho de la tabla px | %
                        Tabla.STYLE.TABLE01, //estilo de la tabla
                        Tabla.ALIGN.LEFT, // alineacion de la tabla
                        cabeceras); //array con las cabeceras de la tabla
                //boton eliminar
                tab.setEliminable(true);
                //boton actualizar
                tab.setModificable(true);
                //url del proyecto
                tab.setPageContext(request.getContextPath());
                //pagina encargada de eliminar
                tab.setPaginaEliminable("/Vehiculos?accion=eliminar");
                //pagina encargada de actualizacion
                tab.setPaginaModificable("/Vehiculos?accion=modificar");
                //pagina encargada de seleccion para operaciones
                tab.setPaginaSeleccionable("/Vehiculos?accion=modificar");
                //icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png");
                //columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
                //pie de tabla
                tab.setPie("Resultado Vehiculos");
                //imprime la tabla en pantalla
                String tabla01 = tab.getTabla();
                request.setAttribute("tabla", tabla01);
                request.setAttribute("valor", request.getParameter("txtBusqueda"));
                request.getRequestDispatcher("Vehiculo/consulta_vehiculo.jsp").forward(request, response);
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Seguros.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Seguros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Vehiculo/consulta_vehiculo.jsp").forward(request, response);
        } else if (accion.equals("7")) {
            request.getRequestDispatcher("Vehiculo/consulta_vehiculo.jsp").forward(request, response);
        } else if (accion.equals("insertar")) {
            request.getRequestDispatcher("Vehiculo/insertar_modificar.jsp").forward(request, response);
        }else if (accion.equals("modificar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Vehiculo v = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Vehiculo());
                request.setAttribute("Seguro", v);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Vehiculo/insertar_modificar.jsp").forward(request, response);
        } else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Vehiculo v = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Vehiculo());
                if (v.getIdvehiculo() != 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/Vehiculos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String idvehiculo = request.getParameter("txtIdvehiculo");
                String modelo = request.getParameter("txtModelo");
                Integer nPasajeros = new Integer(request.getParameter("txtPasajeros"));
                String color = request.getParameter("txtColor");
                String placa = request.getParameter("txtPlaca");
                BigDecimal precio = new BigDecimal(request.getParameter("txtPrecio"));
                String marca = request.getParameter("txtMarca");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    if (idvehiculo != null && !idvehiculo.equals("")) {
                        Vehiculo v = new Vehiculo(Integer.parseInt(idvehiculo), modelo, nPasajeros, color, placa, precio, marca);
                        v = Operaciones.actualizar(v.getIdvehiculo(), v);
                        if (v.getIdvehiculo() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    } else {
                        Vehiculo v = new Vehiculo();
                        v.setModelo(modelo);
                        v.setNumero_pasajeros(nPasajeros);
                        v.setColor(color);
                        v.setPlaca(placa);
                        v.setPrecio(precio);
                        v.setMarca(marca);
                        v = Operaciones.insertar(v);
                        if (v.getIdvehiculo() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }
                    Operaciones.commit();
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();

                    } catch (SQLException ex1) {
                        Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();

                    } catch (SQLException ex) {
                        Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/Seguros");
                break;
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
