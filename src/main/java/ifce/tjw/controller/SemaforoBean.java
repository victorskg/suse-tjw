package ifce.tjw.controller;

import ifce.tjw.dao.PlanoSemaforicoDao;
import ifce.tjw.dao.SemaforoDao;
import ifce.tjw.model.PlanoSemaforico;
import ifce.tjw.model.Semaforo;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@ViewScoped
@ManagedBean
public class SemaforoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idPlano;
    private Semaforo semaforo;
    private SemaforoDao semaforoDao;
    private List<Semaforo> semaforos;
    private PlanoSemaforicoDao planoSemaforicoDao;
    private List<PlanoSemaforico> planosSemaforicos;

    public SemaforoBean() {
    }

    @PostConstruct
    public void init() {
        this.semaforo = new Semaforo();
        this.semaforoDao = new SemaforoDao();
        this.semaforos = semaforoDao.readAll();
        this.planoSemaforicoDao = new PlanoSemaforicoDao();
    }

    public String saveOrUpdate() {
        if (isNull(semaforo.getId())) {
            save();
        } else {
            update();
        }

        return "lista.xhtml?faces-redirect=true";
    }

    public void save() {
        if (nonNull(idPlano)) {
            semaforo.setPlanoSemaforico(planoSemaforicoDao.read(idPlano));
        }
        semaforos.add(semaforoDao.create(semaforo));
    }

    public void update() {
        semaforoDao.update(semaforo);
        semaforos = semaforoDao.readAll();
    }

    public void delete(Semaforo semaforo) {
        semaforoDao.delete(semaforo.getId());
        semaforos = semaforoDao.readAll();
    }

    public String goAdd() {
        this.semaforo = new Semaforo();
        this.idPlano = null;
        this.planosSemaforicos = planoSemaforicoDao.readAll();
        return "formulario.xhtml";
    }

    public String goUpdate(Semaforo semaforo) {
        this.semaforo = semaforo;
        this.idPlano = semaforo.getIdPlanoSemaforico();
        this.planosSemaforicos = planoSemaforicoDao.readAll();
        return "formulario.xhtml";
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public List<Semaforo> getSemaforos() {
        return semaforos;
    }

    public List<PlanoSemaforico> getPlanosSemaforicos() {
        return planosSemaforicos;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public void setSemaforos(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    public void setPlanosSemaforicos(List<PlanoSemaforico> planosSemaforicos) {
        this.planosSemaforicos = planosSemaforicos;
    }
}
