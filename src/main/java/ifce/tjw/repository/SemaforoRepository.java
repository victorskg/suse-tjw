package ifce.tjw.repository;

import ifce.tjw.model.Semaforo;
import ifce.tjw.producer.EntityManagerProducer;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

public class SemaforoRepository implements CRUDRepository<Semaforo, Integer> {

    public SemaforoRepository() {
    }

    @Override
    @Transactional
    public Semaforo create(Semaforo entity) {
        var entityManager = EntityManagerProducer.getEntityManager();
        var entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(entity);
        entityTransaction.commit();
        entityManager.close();

        return entity;
    }

    @Override
    public Semaforo read(Integer id) {
        var entityManager = EntityManagerProducer.getEntityManager();
        var semaforo = entityManager.find(Semaforo.class, id);

        entityManager.close();

        return Optional.ofNullable(semaforo).orElseThrow(() -> {
            throw new NoResultException(format("Não foi possível encontrar o semáforo de id %d", id));
        });
    }

    @Override
    public List<Semaforo> readAll() {
        var entityManager = EntityManagerProducer.getEntityManager();
        var semaforos = entityManager.createQuery("SELECT s FROM Semaforo s", Semaforo.class).getResultList();

        entityManager.close();

        return semaforos;
    }

    @Override
    @Transactional
    public void update(Semaforo entity) {
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

        var semaforo = entityManager.find(Semaforo.class, id);
        entityManager.remove(semaforo);

        entityTransaction.commit();
        entityManager.close();
    }

}
