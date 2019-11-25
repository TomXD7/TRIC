package com.tric.control;

import com.tric.entidades.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter io = response.getWriter();
        String acccion = request.getParameter("accion");
        if (acccion == null) {
            HttpSession s = request.getSession();
            List<Menu> per = (List<Menu>) s.getAttribute("Permisos");
            List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre() == 0).collect(Collectors.toList());
            request.setAttribute("MenuPrincipal", MenuPrincipal);
            // request.setAttribute("SubMenu", per);
            if(MenuPrincipal == null){
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            String op = request.getParameter("op");
            if (op != null) {
                List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre() == Integer.parseInt(op)).collect(Collectors.toList());
                request.setAttribute("PermisosAsignados", PermisosAsignados);
            }
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (acccion.equals("logout")) {
            logout(request, response);
        }else if(acccion.equals("1")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }else if(acccion.equals("3")){
                request.getRequestDispatcher("Informacion/Agencias.jsp").forward(request, response);
        }else if(acccion.equals("4")){
                request.getRequestDispatcher("Informacion/Ofrecemos.jsp").forward(request, response);
        }else if(acccion.equals("5")){
                request.getRequestDispatcher("Informacion/Que_Somos.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("Usuario");
        sesion.removeAttribute("Nombre");
        sesion.removeAttribute("Rol");
        sesion.invalidate();
        response.sendRedirect("Login");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
