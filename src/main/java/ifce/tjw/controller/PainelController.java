package ifce.tjw.controller;

import ifce.tjw.repository.SemaforoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@WebServlet("/painel")
public class PainelController  extends HttpServlet {

    private final String forwardRoot;
    private final SemaforoRepository repository;

    public PainelController() {
        this.forwardRoot = "views/Painel/";
        this.repository = new SemaforoRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "Painel.jsp";
        var semaforosComPlano = repository.readAll().stream()
                .filter(s -> nonNull(s.getPlanoSemaforico()))
                .collect(Collectors.toList());

        request.setAttribute("semaforos", semaforosComPlano);

        var viewDispatcher = request.getRequestDispatcher(forward);
        viewDispatcher.forward(request, response);
    }

}
