package ifce.tjw.dao;

import ifce.tjw.model.PlanoSemaforico;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class PlanoSemaforicoDao extends AbstractDao<PlanoSemaforico, Integer> {

    @Inject
    protected EntityManager entityManger;

    @Override
    protected EntityManager entityManager() {
        return this.entityManger;
    }
}
