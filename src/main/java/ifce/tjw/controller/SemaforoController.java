package ifce.tjw.controller;

import ifce.tjw.model.Endereco;
import ifce.tjw.model.Semaforo;
import ifce.tjw.model.enums.Acao;
import ifce.tjw.repository.SemaforoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ifce.tjw.utils.Utils.populateBean;
import static java.util.Objects.isNull;

@WebServlet("/semaforos")
public class SemaforoController extends HttpServlet {

    private final String forwardRoot;
    private final SemaforoRepository repository;

    public SemaforoController() {
        super();
        this.forwardRoot = "views/Semaforos/";
        this.repository = new SemaforoRepository();
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
        var semaforo = new Semaforo();
        var endereco = new Endereco();

        populateBean(semaforo, request);
        populateBean(endereco, request);
        semaforo.setEndereco(endereco);

        if (semaforo.getId().equals(0) || isNull(semaforo.getId())) {
            semaforo.setId(null);
            repository.create(semaforo);
        } else {
            repository.update(semaforo);
        }

        read(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "FormularioSemaforos.jsp";
        request.removeAttribute("acao");
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "ListaSemaforos.jsp";
        request.removeAttribute("acao");

        request.setAttribute("semaforos", repository.readAll());
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "FormularioSemaforos.jsp";
        request.removeAttribute("acao");request.removeAttribute("acao");

        var id = Integer.valueOf(request.getParameter("id"));
        var semaforo = repository.read(id);

        request.setAttribute("semaforo", semaforo);
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var forward = forwardRoot + "ListaSemaforos.jsp";
        request.removeAttribute("acao");

        var id = Integer.valueOf(request.getParameter("id"));
        repository.delete(id);

        request.setAttribute("semaforos", repository.readAll());
        var viewDispatcher = request.getRequestDispatcher(forward);

        viewDispatcher.forward(request, response);
    }

}
