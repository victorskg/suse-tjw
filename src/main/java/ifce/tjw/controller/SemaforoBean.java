package ifce.tjw.controller;

import ifce.tjw.dao.PlanoSemaforicoDao;
import ifce.tjw.dao.SemaforoDao;
import ifce.tjw.model.PlanoSemaforico;
import ifce.tjw.model.Semaforo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Named
@RequestScoped
public class SemaforoBean implements Serializable {

    private Integer idPlano;

    @Inject
    private Semaforo semaforo;

    @Inject
    private SemaforoDao semaforoDao;

    private List<Semaforo> semaforos;

    @Inject
    private PlanoSemaforicoDao planoSemaforicoDao;
    private List<PlanoSemaforico> planosSemaforicos;

    @PostConstruct
    public void init() {
        this.semaforos = semaforoDao.readAll();
        this.planosSemaforicos = planoSemaforicoDao.readAll();
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

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public List<Semaforo> getSemaforos() {
        return semaforos;
    }

    public void setSemaforos(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    public List<PlanoSemaforico> getPlanosSemaforicos() {
        return planosSemaforicos;
    }

    public void setPlanosSemaforicos(List<PlanoSemaforico> planosSemaforicos) {
        this.planosSemaforicos = planosSemaforicos;
    }
}
