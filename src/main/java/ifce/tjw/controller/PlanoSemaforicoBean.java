package ifce.tjw.controller;

import ifce.tjw.dao.PlanoSemaforicoDao;
import ifce.tjw.model.PlanoSemaforico;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import static java.util.Objects.isNull;

@ViewScoped
@ManagedBean
public class PlanoSemaforicoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private PlanoSemaforico planoSemaforico;
    private PlanoSemaforicoDao planoSemaforicoDao;
    private List<PlanoSemaforico> planosSemaforicos;

    public PlanoSemaforicoBean() {
    }

    @PostConstruct
    public void init() {
        this.planoSemaforico = new PlanoSemaforico();
        this.planoSemaforicoDao = new PlanoSemaforicoDao();
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

    public void save() {
        planosSemaforicos.add(planoSemaforicoDao.create(planoSemaforico));
        planoSemaforico = new PlanoSemaforico();
    }

    public void update() {
        planoSemaforicoDao.update(planoSemaforico);
        planoSemaforico = new PlanoSemaforico();
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
