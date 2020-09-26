package ifce.tjw.controller;

import ifce.tjw.model.Endereco;
import ifce.tjw.model.Semaforo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/semaforos")
public class SemaforoController extends HttpServlet {

    private final String forwardRoot = "views/Semaforos/";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "ListaSemaforos.jsp";
        var endereco = new Endereco("CE", "Fortaleza", "Granja Portugal", "Rua Teodoro de Castro");

        request.setAttribute("semaforos", List.of(new Semaforo("S01", endereco)));
        var viewDispatcher = request.getRequestDispatcher(forward);
        viewDispatcher.forward(request, response);
    }

}
