package ifce.tjw.dao;

import ifce.tjw.model.Semaforo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class SemaforoDao extends AbstractDao<Semaforo, Integer> {

    @Inject
    protected EntityManager entityManger;

    @Override
    protected EntityManager entityManager() {
        return this.entityManger;
    }
}
