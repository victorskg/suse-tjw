package ifce.tjw.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/painel")
public class PainelController  extends HttpServlet {

    private final String forwardRoot = "views/Painel/";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "Painel.jsp";

        var viewDispatcher = request.getRequestDispatcher(forward);
        viewDispatcher.forward(request, response);
    }

}
