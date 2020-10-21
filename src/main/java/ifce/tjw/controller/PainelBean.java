package ifce.tjw.controller;

import ifce.tjw.dao.SemaforoDao;
import ifce.tjw.model.Semaforo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class PainelBean implements Serializable {

    @Inject
    private SemaforoDao semaforoDao;
    private List<Semaforo> semaforos;

    @PostConstruct
    public void init() {
        this.semaforos = semaforoDao.findAllWithPlan();
    }

    public List<Semaforo> getSemaforos() {
        return semaforos;
    }

    public void setSemaforos(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }
}
