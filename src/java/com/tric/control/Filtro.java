
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtro implements Filter {

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public Filtro() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        log("Filtro:doFilter()");

        //Primero, aseguramos los parámetros de entrada a sus tipos correctos
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Object logueo = req.getSession().getAttribute("User");

        if (logueo == null) {
            req.getRequestDispatcher("index.jsp").forward(request, response);
        }
        //Segundo, realizamos las acciones PRE-FILTRO
        //Opcionalmente, invocamos a los filtros encadenados
        chain.doFilter(req, res);

        //Realizamos las acciones POST-FILTRO
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            log("Filtro: Initializing filter");
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
