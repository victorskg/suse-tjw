package ifce.tjw.repository;

import ifce.tjw.model.Semaforo;
import ifce.tjw.producer.EntityManagerProducer;

import java.util.List;

public class SemaforoRepository implements CRUDRepository<Semaforo, Integer> {

    public SemaforoRepository() {
    }

    @Override
    public Semaforo create(Semaforo entity) {
        return null;
    }

    @Override
    public Semaforo read(Integer id) {
        return null;
    }

    @Override
    public List<Semaforo> readAll() {
        var manager = EntityManagerProducer.getEntityManager();
        manager.getTransaction().begin();
        var semaforos = manager.createQuery("SELECT s FROM Semaforo s", Semaforo.class).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return semaforos;
    }

    @Override
    public void update(Semaforo entity) {

    }

    @Override
    public void delete(Integer id) {

    }

}
