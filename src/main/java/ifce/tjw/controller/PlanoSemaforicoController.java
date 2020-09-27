package ifce.tjw.controller;

import ifce.tjw.model.Endereco;
import ifce.tjw.model.PlanoSemaforico;
import ifce.tjw.model.Semaforo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/planos-semaforicos")
public class PlanoSemaforicoController extends HttpServlet {

    private final String forwardRoot = "views/Semaforos/";

    public List<Semaforo> semaforos = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "ListaPlanosSemaforicos.jsp";

        request.setAttribute("planos", List.of(new PlanoSemaforico(30,30,30, semaforos)));
        var viewDispatcher = request.getRequestDispatcher(forward);
        viewDispatcher.forward(request, response);
    }
}
