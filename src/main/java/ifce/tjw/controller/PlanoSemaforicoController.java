package ifce.tjw.controller;

import ifce.tjw.model.PlanoSemaforico;
import ifce.tjw.model.enums.Acao;
import ifce.tjw.repository.PlanoSemaforicoRepository;
import ifce.tjw.repository.SemaforoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ifce.tjw.utils.Utils.populateBean;
import static java.util.Objects.isNull;

@WebServlet("/planos-semaforicos")
public class PlanoSemaforicoController extends HttpServlet {

    private final String forwardRoot;
    private final PlanoSemaforicoRepository repository;

    public PlanoSemaforicoController() {
        super();
        this.forwardRoot = "views/PlanosSemaforicos/";
        this.repository = new PlanoSemaforicoRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (Acao.fromRequest(request)) {
            case CREATE:
                create(request, response);
                break;
            case READ:
                read(request, response);
                break;
            case UPDATE:
                update(request, response);
                break;
            case DELETE:
                delete(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var plano = new PlanoSemaforico();

        populateBean(plano, request);

        if (isNull(plano.getId()) || plano.getId().equals(0)) {
            plano.setId(null);
            repository.create(plano);
        } else {
            repository.update(plano);
        }

        read(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "FormularioPlanosSemaforicos.jsp";
        request.removeAttribute("acao");
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "ListaPlanosSemaforicos.jsp";
        request.removeAttribute("acao");

        request.setAttribute("planos", repository.readAll());
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "FormularioPlanosSemaforicos.jsp";
        request.removeAttribute("acao");

        var id = Integer.valueOf(request.getParameter("id"));
        var plano = repository.read(id);

        request.setAttribute("plano", plano);
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "ListaPlanosSemaforicos.jsp";
        request.removeAttribute("acao");

        var id = Integer.valueOf(request.getParameter("id"));
        repository.delete(id);

        request.setAttribute("planos", repository.readAll());
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

}
