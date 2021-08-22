package Week2.Day5;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/private/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // cast servletRequest/servletResponse to HttpServletRequest/HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        if (session == null) {
            // if no session redirect to login page
            response.sendRedirect(request.getContextPath() + "/public/login.jsp");
        } else if (session.getAttribute("username") != null) {
            // if session is valid complete filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // if session is not valid redirect to login page
            response.sendError(401, "Session is not valid");
        }

//        if (session != null && session.getAttribute("username") != null) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            response.sendRedirect(request.getContextPath() + "/public/login.jsp");
//        }

    }
}
