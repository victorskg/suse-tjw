package ifce.tjw.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController  extends HttpServlet {

    private final String user = "admin";
    private final String password = "admin";
    private final String failForwardRedirect = "index.jsp";
    private final String forwardRedirect = "views/Painel/Painel.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var ususario = request.getParameter("usuario");
        var senha = request.getParameter("senha");

        RequestDispatcher viewDispatcher;
        if (user.equals(ususario) && password.equals(senha)) {
            viewDispatcher = request.getRequestDispatcher(forwardRedirect);
        } else {
            request.setAttribute("error", true);
            viewDispatcher = request.getRequestDispatcher(failForwardRedirect);
        }
        viewDispatcher.forward(request, response);
    }

}
