package ifce.tjw.repository;

import ifce.tjw.model.PlanoSemaforico;
import ifce.tjw.producer.EntityManagerProducer;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

public class PlanoSemaforicoRepository implements CRUDRepository<PlanoSemaforico, Integer> {

    public PlanoSemaforicoRepository() {
    }

    @Override
    @Transactional
    public PlanoSemaforico create(PlanoSemaforico entity) {
        entity.getSemaforos().forEach(s -> {
            s.setPlanoSemaforico(entity);
        });

        var entityManager = EntityManagerProducer.getEntityManager();
        var entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(entity);
        entityTransaction.commit();
        entityManager.close();

        return entity;
    }

    @Override
    public PlanoSemaforico read(Integer id) {
        var entityManager = EntityManagerProducer.getEntityManager();
        var planoSemaforico = entityManager.find(PlanoSemaforico.class, id);

        entityManager.close();

        return Optional.ofNullable(planoSemaforico).orElseThrow(() -> {
            throw new NoResultException(format("Não foi possível encontrar o semáforo de id %d", id));
        });
    }

    @Override
    public List<PlanoSemaforico> readAll() {
        var entityManager = EntityManagerProducer.getEntityManager();
        var planos = entityManager.createQuery("SELECT p FROM PlanoSemaforico p", PlanoSemaforico.class).getResultList();

        entityManager.close();

        return planos;
    }

    @Override
    @Transactional
    public void update(PlanoSemaforico entity) {
        var entityManager = EntityManagerProducer.getEntityManager();
        var entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.merge(entity);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        var entityManager = EntityManagerProducer.getEntityManager();
        var entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        var planoSemaforico = entityManager.find(PlanoSemaforico.class, id);
        entityManager.remove(planoSemaforico);

        entityTransaction.commit();
        entityManager.close();
    }
}
