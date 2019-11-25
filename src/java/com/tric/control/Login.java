package com.tric.control;

import com.tric.conexion.Conexion;
import com.tric.conexion.ConexionPool;
import com.tric.entidades.Menu;
import com.tric.entidades.Usuario;
import com.tric.operaciones.Operaciones;
import com.tric.utilerias.Hash;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (accion.equals("login")) {
            try {
                iniciarSesion(request, response);
            } catch (SQLException ex) {
            }
        }else if(accion.equals("registro")){
            
        }
    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");

        //Para uso del desarrollador 
        PrintWriter io = response.getWriter();
        if (usuario == null) {
            usuario = "";
        }
        if (clave == null) {
            clave = "";
        }
        try {
            Conexion con = new ConexionPool();
            con.conectar();
            Operaciones.abrirConexion(con);
            Operaciones.iniciarTransaccion();
            if (con.getConexion() == null) {
                request.setAttribute("error", 1);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                HttpSession sesion = request.getSession();
                Usuario u = Operaciones.get(usuario, new Usuario());
                if (u.getIdusuario() != null) {
                    if (u.getContraseña().equals(Hash.generarHash(clave, Hash.SHA256))) {
                        sesion.setAttribute("Usuario", u.getIdusuario());
                        sesion.setAttribute("Rol", u.getIdrol());
                        sesion.setAttribute("User", u);
                        List<Menu> permisos = getPermisos(u.getIdrol());
                        List<Menu> MenuPrincipal = permisos.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
                        sesion.setAttribute("MenuPrincipal", MenuPrincipal);
                        sesion.setAttribute("Permisos", permisos);
                        response.sendRedirect("Principal");
                    } else {
                        request.setAttribute("error", 2);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("error", 2);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
            Operaciones.commit();
            io.print("Se logro conectar al pool");
        } catch (Exception ex) {
            io.print("Error al conectarse al pool");
            Operaciones.rollback();
        } finally {
            Operaciones.cerrarConexion();
            io.print("Se Cerro la conexion");
        }
    }

    private List<Menu> getPermisos(Integer idrol) throws SQLException {
        List<Menu> permisos = new ArrayList();
        try {
            String sql = "select * from menu where idmenu in (select idmenu from permiso where idrol = ?)";
            //Este objeto se crea para podre crear una lista de parametros en los cuales iran los valores que se reemplazaran en 
            //en la sql que se le pasa al metodo consultar(sql,param)
            List<Object> param = new ArrayList();
            param.add(idrol);
            //Los parametros son un String con una sql y una lista de parametros de tipo Objeto
            //Devuelve un array de String que fue llenado por un Resultset 
            String[][] rs = Operaciones.consultar(sql, param);

            for (int i = 0; i < rs[0].length; i++) {
                //array[columna][fila]
                //Se sabe que son 5 columnas 0-> 4, si el campo 4 idpadre es nulo se asigna un 0 
                Menu m = new Menu(Integer.parseInt(rs[0][i]), rs[1][i], rs[2][i], rs[3][i], Integer.parseInt(rs[4][i] == null ? "0" : rs[4][i]));
                //El objeto m de tipo Menu guarda un registro completo y luego se agrega a una lista de tipo menu -> permisos.add()
                permisos.add(m);
            }
        } catch (Exception ex) {
            Operaciones.rollback();
        }

        return permisos;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
