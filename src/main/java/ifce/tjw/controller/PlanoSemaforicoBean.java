package ifce.tjw.controller;

import ifce.tjw.dao.PlanoSemaforicoDao;
import ifce.tjw.model.PlanoSemaforico;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Objects.isNull;

@Named
@RequestScoped
public class PlanoSemaforicoBean implements Serializable {

    @Inject
    private PlanoSemaforico planoSemaforico;

    @Inject
    private PlanoSemaforicoDao planoSemaforicoDao;
    private List<PlanoSemaforico> planosSemaforicos;

    @PostConstruct
    public void init() {
        this.planosSemaforicos = planoSemaforicoDao.readAll();
    }

    public String saveOrUpdate() {
        if (isNull(planoSemaforico.getId())) {
            save();
        } else {
            update();
        }

        return "lista.xhtml?faces-redirect=true";
    }

    public String goAdd() {
        return "formulario.xhtml";
    }

    public void save() {
        planosSemaforicos.add(planoSemaforicoDao.create(planoSemaforico));
        planoSemaforico = new PlanoSemaforico();
    }

    public void update() {
        planoSemaforicoDao.update(planoSemaforico);
        planosSemaforicos = planoSemaforicoDao.readAll();
    }

    public void delete(PlanoSemaforico planoSemaforico) {
        planoSemaforicoDao.delete(planoSemaforico.getId());
        planosSemaforicos = planoSemaforicoDao.readAll();
    }

    public String goUpdate(PlanoSemaforico planoSemaforico) {
        this.planoSemaforico = planoSemaforico;
        return "formulario.xhtml";
    }

    public PlanoSemaforico getPlanoSemaforico() {
        return planoSemaforico;
    }

    public List<PlanoSemaforico> getPlanosSemaforicos() {
        return planosSemaforicos;
    }
}
