package com.tric.control;

import com.tric.conexion.Conexion;
import com.tric.conexion.ConexionPool;
import com.tric.entidades.Usuario;
import com.tric.operaciones.Operaciones;
import com.tric.utilerias.Hash;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Usuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
            }
        } else if (accion.equals("insertar")) {
            request.getRequestDispatcher("Usuario/registro_usuario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar": {
                String usuario = request.getParameter("txtUsuario");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String correo = request.getParameter("txtCorreo");
                String telefono = request.getParameter("txtTelefono");
                String password = Hash.generarHash(request.getParameter("txtPassword"), Hash.SHA256);
                Integer rol = 2;
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    Usuario u = new Usuario();
                    u.setIdusuario(usuario);
                    u.setNombres(nombre);
                    u.setApellidos(apellido);
                    u.setCorreo(correo);
                    u.setTelefono(telefono);
                    u.setContraseña(password);
                    u.setIdrol(rol);
                    u = Operaciones.insertar(u);
                    Operaciones.commit();
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }finally{
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
