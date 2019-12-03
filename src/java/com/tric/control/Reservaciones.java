package com.tric.control;

import com.tric.conexion.Conexion;
import com.tric.conexion.ConexionPool;
import com.tric.entidades.Mejora;
import com.tric.entidades.Reservacion;
import com.tric.entidades.Usuario;
import com.tric.operaciones.Operaciones;
import com.tric.utilerias.Tabla;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reservaciones extends HttpServlet {

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
                    sql = "select * from reservcion where idusuario like ?";
                } else {
                    sql = "select * from reservacion";
                }
                String[][] reservacion = null;
                if (request.getParameter("txtBusqueda") != null) {
                    List<Object> params = new ArrayList<>();
                    params.add("%" + request.getParameter("txtBusqueda").toString() + "%");
                    reservacion = Operaciones.consultar(sql, params);
                } else {
                    reservacion = Operaciones.consultar(sql, null);
                }
                //declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                    "ID Reservacion",
                    "Fecha Inicio",
                    "Fecha Fin",
                    "Agencia",
                    "ID Usuario",
                    "ID Vehiculo",
                    "ID Mejora",
                    "ID Seguro"
                };
                //variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(reservacion, //array que contiene los datos
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
                tab.setPaginaEliminable("/Reservacion?accion=eliminar");
                //pagina encargada de actualizacion
                tab.setPaginaModificable("/Reservacion?accion=modificar");
                //pagina encargada de seleccion para operaciones
                tab.setPaginaSeleccionable("/Reservacion?accion=modificar");
                //icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png");
                //columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
                //pie de tabla
                tab.setPie("Resultado Reservaciones");
                //imprime la tabla en pantalla
                String tabla01 = tab.getTabla();
                request.setAttribute("tabla", tabla01);
                request.setAttribute("valor", request.getParameter("txtBusqueda"));
                request.getRequestDispatcher("Reservacion/consulta_mejora.jsp").forward(request, response);
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
            request.getRequestDispatcher("Reservacion/consulta_reservacion.jsp").forward(request, response);
        } else if (accion.equals("2")) {
            request.getRequestDispatcher("Reservacion/consulta_reservacion.jsp").forward(request, response);
        } else if (accion.equals("insertar")) {
            request.getRequestDispatcher("Reservacion/insertar_modificar.jsp").forward(request, response);
        }else if (accion.equals("modificar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Reservacion r = Operaciones.get(Integer.parseInt(request.getParameter("id")), new Reservacion());
                request.setAttribute("Reservacion", r);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Reservacion.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Reservacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Reservacion/insertar_modificar.jsp").forward(request, response);
        } else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                Reservacion r = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new Reservacion());
                if (r.getIdreservacion() != 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Reservacion.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Reservacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/Reservaciones");
        } else if(accion.equals("mejoras")){
             try {                
                 Conexion conn = new ConexionPool();
                              conn.conectar();               
             Operaciones.abrirConexion(conn);               
             Operaciones.iniciarTransaccion();                     
             String sql = "select idmejora, nombre, precio from mejora;";    
             String[][] origenes = Operaciones.consultar(sql, null);          
             //declaracion de cabeceras a usar en la tabla HTML            
             String[] cabeceras = new String[]{               
                 "Id Mejora",               
                 "Mejora",               
                 "Precio"
                      };             
             //variable de tipo Tabla para generar la Tabla HTML    
             Tabla tab = new Tabla(origenes, //array que contiene los datos       
                     "100%", //ancho de la tabla px | %         
                     Tabla.STYLE.TABLE01, //estilo de la tabla     
                     Tabla.ALIGN.LEFT,  // alineacion de la tabla        
                     cabeceras); //array con las cabeceras de la tabla   
             tab.setMetodoFilaSeleccionable("_Seleccionar_");            
             //url del proyecto        
             tab.setPageContext(request.getContextPath());  
             tab.setFilaSeleccionable(true);              
             //icono para modificar y eliminar //         
             tab.setIconoModificable("/iconos/edit.png"); //    
             
             tab.setIconoEliminable("/iconos/delete.png");      
             //columnas seleccionables            
             tab.setColumnasSeleccionables(new int[]{1});        
             //pie de tabla           
             tab.setPie("Resultado Mejoras");   
             //imprime la tabla en pantalla         
             String tabla01="No hay datos";         
             if (origenes!=null)                    
                 tabla01= tab.getTabla();          
             request.setAttribute("tabla", tabla01);  
             request.getRequestDispatcher("Reservacion/mejoras.jsp").forward(request, response); 
             } catch(Exception ex) {               
                 try {                    
                     Operaciones.rollback();     
                 } catch (SQLException ex1) {     
                     Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex1); 
                 }             
             } finally {       
                 try {          
                     Operaciones.cerrarConexion();      
                 } catch (SQLException ex) {         
                     Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex);  
                 }           
             }   
        }else if(accion.equals("seguros")){
             try {                
                 Conexion conn = new ConexionPool();
                              conn.conectar();               
             Operaciones.abrirConexion(conn);               
             Operaciones.iniciarTransaccion();                     
             String sql = "select idseguro, nombre, precio from seguro;";    
             String[][] origenes = Operaciones.consultar(sql, null);          
             //declaracion de cabeceras a usar en la tabla HTML            
             String[] cabeceras = new String[]{               
                 "Id Seguro",               
                 "Seguro",               
                 "Precio"
                      };             
             //variable de tipo Tabla para generar la Tabla HTML    
             Tabla tab = new Tabla(origenes, //array que contiene los datos       
                     "100%", //ancho de la tabla px | %         
                     Tabla.STYLE.TABLE01, //estilo de la tabla     
                     Tabla.ALIGN.LEFT,  // alineacion de la tabla        
                     cabeceras); //array con las cabeceras de la tabla   
             tab.setMetodoFilaSeleccionable("_Seleccionar_");            
             //url del proyecto        
             tab.setPageContext(request.getContextPath());  
             tab.setFilaSeleccionable(true);              
             //icono para modificar y eliminar //         
             tab.setIconoModificable("/iconos/edit.png"); //    
             
             tab.setIconoEliminable("/iconos/delete.png");      
             //columnas seleccionables            
             tab.setColumnasSeleccionables(new int[]{1});        
             //pie de tabla           
             tab.setPie("Resultado Seguros");   
             //imprime la tabla en pantalla         
             String tabla01="No hay datos";         
             if (origenes!=null)                    
                 tabla01= tab.getTabla();          
             request.setAttribute("tabla", tabla01);  
             request.getRequestDispatcher("Reservacion/seguros.jsp").forward(request, response); 
             } catch(Exception ex) {               
                 try {                    
                     Operaciones.rollback();     
                 } catch (SQLException ex1) {     
                     Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex1); 
                 }             
             } finally {       
                 try {          
                     Operaciones.cerrarConexion();      
                 } catch (SQLException ex) {         
                     Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex);  
                 }           
             }   
        }else if(accion.equals("vehiculos")){
             try {                
                 Conexion conn = new ConexionPool();
                              conn.conectar();               
             Operaciones.abrirConexion(conn);               
             Operaciones.iniciarTransaccion();                     
             String sql = "select idvehiculo, numero_pasajeros, placa, marca, tipo, descripcion, precio from vehiculo";    
             String[][] origenes = Operaciones.consultar(sql, null);          
             //declaracion de cabeceras a usar en la tabla HTML            
             String[] cabeceras = new String[]{               
                 "Id Vehiculo",                          
                 "Numero de pasajeros",
                 "Placa",
                 "Marca",
                 "Tipo",
                 "Descripcion",
                 "Precio",
                      };             
             //variable de tipo Tabla para generar la Tabla HTML    
             Tabla tab = new Tabla(origenes, //array que contiene los datos       
                     "100%", //ancho de la tabla px | %         
                     Tabla.STYLE.TABLE01, //estilo de la tabla     
                     Tabla.ALIGN.LEFT,  // alineacion de la tabla        
                     cabeceras); //array con las cabeceras de la tabla   
             tab.setMetodoFilaSeleccionable("_Seleccionar_");            
             //url del proyecto        
             tab.setPageContext(request.getContextPath());  
             tab.setFilaSeleccionable(true);              
             //icono para modificar y eliminar //         
             tab.setIconoModificable("/iconos/edit.png"); //    
             
             tab.setIconoEliminable("/iconos/delete.png");      
             //columnas seleccionables            
             tab.setColumnasSeleccionables(new int[]{1});        
             //pie de tabla           
             tab.setPie("Resultado Vehiculos");   
             //imprime la tabla en pantalla         
             String tabla01="No hay datos";         
             if (origenes!=null)                    
                 tabla01= tab.getTabla();          
             request.setAttribute("tabla", tabla01);  
             request.getRequestDispatcher("Reservacion/vehiculos.jsp").forward(request, response); 
             } catch(Exception ex) {               
                 try {                    
                     Operaciones.rollback();     
                 } catch (SQLException ex1) {     
                     Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex1); 
                 }             
             } finally {       
                 try {          
                     Operaciones.cerrarConexion();      
                 } catch (SQLException ex) {         
                     Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex);  
                 }           
             }   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                try {
                    String idreservacion = request.getParameter("txtIdreservacion");
                    Date fi = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("txtFechaInicio"));
                    Timestamp fechainicio = new Timestamp(fi.getTime());
                    Date fu = new SimpleDateFormat("dd/mm/yyyy").parse(request.getParameter("txtFechaFin"));
                    Timestamp fechafin = new Timestamp(fu.getTime());
                    String agencia = request.getParameter("txtAgencia");
                    int dias=(int) ((fechafin.getTime()-fechainicio.getTime())/86400000);
                    BigDecimal d = new BigDecimal(dias);
                    BigDecimal total = new BigDecimal(request.getParameter("txtTotal"));
                    total = total.multiply(d);
                    String idvehiculo = request.getParameter("txtVehiculo");
                    String idmejora = request.getParameter("txtMejora");
                    String idseguro = request.getParameter("txtSeguro");
                    try {
                        Conexion conn = new ConexionPool();
                        conn.conectar();
                        Operaciones.abrirConexion(conn);
                        Operaciones.iniciarTransaccion();
                        if (idreservacion != null && !idreservacion.equals("")) {
                            Reservacion r = new Reservacion(Integer.parseInt(idreservacion), fechainicio, fechafin, agencia, total, "", Integer.parseInt(idvehiculo), Integer.parseInt(idmejora), Integer.parseInt(idseguro));
                            r = Operaciones.actualizar(r.getIdreservacion(), r);
                            if (r.getIdreservacion() != 0) {
                                request.getSession().setAttribute("resultado", 1);
                            } else {
                                request.getSession().setAttribute("resultado", 0);
                            }
                        } else {
                            Usuario u = new Usuario();
                            Reservacion r = new Reservacion();
                            r.setFecha_inicio(fechainicio);
                            r.setFecha_fin(fechafin);
                            r.setAgencia(agencia);
                            r.setIdusuario(u.getIdusuario());
                            r.setIdvehiculo(Integer.parseInt(idvehiculo));
                            r.setIdmejora(Integer.parseInt(idmejora));
                            r.setIdproducto(Integer.parseInt(idseguro));
                            r.setTotal(total);
                            r = Operaciones.insertar(r);
                            if (r.getIdreservacion() != 0) {
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
                            Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                        request.getSession().setAttribute("resultado", 2);
                        ex.printStackTrace();
                    } finally {
                        try {
                            Operaciones.cerrarConexion();
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    response.sendRedirect(request.getContextPath() + "/Reservaciones");
                    break;
                } catch (ParseException ex) {
                    Logger.getLogger(Reservaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
