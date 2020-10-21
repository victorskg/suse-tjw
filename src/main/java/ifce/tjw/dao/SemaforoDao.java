package ifce.tjw.dao;

import ifce.tjw.model.Semaforo;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class SemaforoDao extends AbstractDao<Semaforo, Integer> {

    @Inject
    protected EntityManager entityManger;

    @Override
    protected EntityManager entityManager() {
        return this.entityManger;
    }

    public List<Semaforo> findAllWithPlan() {
        var jpql = "SELECT e FROM Semaforo e WHERE e.planoSemaforico IS NOT NULL";
        return this.entityManger.createQuery(jpql, Semaforo.class).getResultList();
    }
}
