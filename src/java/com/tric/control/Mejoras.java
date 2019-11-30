package com.tric.control;

import com.tric.conexion.Conexion;
import com.tric.conexion.ConexionPool;
import com.tric.entidades.Mejora;
import com.tric.operaciones.Operaciones;
import com.tric.utilerias.Tabla;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mejoras extends HttpServlet {

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
                    sql = "select * from mejora where nombre like ?";
                } else {
                    sql = "select * from mejora";
                }
                String[][] mejoras = null;
                if (request.getParameter("txtBusqueda") != null) {
                    List<Object> params = new ArrayList<>();
                    params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                    mejoras = Operaciones.consultar(sql, params);
                } else {
                    mejoras = Operaciones.consultar(sql, null);
                }
                //declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                    "ID Mejora",
                    "Nombre Mejora",
                    "Precio",
                    "Detalle del servicio"
                };
                //variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(mejoras, //array que contiene los datos
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
                tab.setPaginaEliminable("/Mejoras?accion=eliminar");
                //pagina encargada de actualizacion
                tab.setPaginaModificable("/Mejoras?accion=modificar");
                //pagina encargada de seleccion para operaciones
                tab.setPaginaSeleccionable("/Mejoras?accion=modificar");
                //icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png");
                //columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
                //pie de tabla
                tab.setPie("Resultado mejoras");
                //imprime la tabla en pantalla
                String tabla01 = tab.getTabla();
                request.setAttribute("tabla", tabla01);
                request.setAttribute("valor", request.getParameter("txtBusqueda"));
                request.getRequestDispatcher("Mejora/consulta_mejora.jsp").forward(request, response);
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Mejoras.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Mejoras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (accion.equals("8")) {
            request.getRequestDispatcher("Mejora/consulta_mejora.jsp").forward(request, response);
        } else if (accion.equals("insertar")) {
            request.getRequestDispatcher("Mejora/insertar_modificar.jsp").forward(request, response);
        }else if (accion.equals("modificar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Mejora m = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Mejora());
                request.setAttribute("Mejora", m);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Mejora.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Mejora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Mejora/insertar_modificar.jsp").forward(request, response);
        } else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Mejora m = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Mejora());
                if (m.getIdmejora() != 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Mejora.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Mejora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/Mejoras");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String idmejora = request.getParameter("txtIdmejora");
                String mejora = request.getParameter("txtMejora");
                BigDecimal precio = new BigDecimal(request.getParameter("txtPrecio"));
                String detalle = request.getParameter("txtDetalle");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    if (idmejora != null && !idmejora.equals("")) {
                        Mejora m = new Mejora(Integer.parseInt(idmejora), mejora, precio, detalle);
                        m = Operaciones.actualizar(m.getIdmejora(), m);
                        if (m.getIdmejora() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    } else {
                        Mejora m = new Mejora();
                        m.setNombre(mejora);
                        m.setPrecio(precio);
                        m.setDetalle_servicio(detalle);
                        m = Operaciones.insertar(m);
                        if (m.getIdmejora() != 0) {
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
                        Logger.getLogger(Mejoras.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                    ex.printStackTrace();
                } finally {
                    try {
                        Operaciones.cerrarConexion();

                    } catch (SQLException ex) {
                        Logger.getLogger(Mejoras.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/Mejoras");
                break;
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
