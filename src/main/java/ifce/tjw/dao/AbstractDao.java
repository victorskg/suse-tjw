package ifce.tjw.dao;

import ifce.tjw.model.EntidadeBase;
import ifce.tjw.producer.EntityManagerProducer;

import javax.persistence.EntityManager;
import java.util.List;

import static java.lang.String.format;

public abstract class AbstractDao<T extends EntidadeBase<I>, I extends Number> {

    private final Class<T> daoClass;
    private final EntityManager entityManager;

    public AbstractDao(Class<T> daoClass) {
        this.daoClass = daoClass;
        this.entityManager = EntityManagerProducer.getEntityManager();
    }

    public T create(T entity) {
        var transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();

        return entity;
    }

    public T read(I id) {
        return entityManager.find(daoClass, id);
    }

    public List<T> readAll() {
        var jpql = format("SELECT e FROM %s e", daoClass.getSimpleName());
        var query = entityManager.createQuery(jpql, daoClass);

        return query.getResultList();
    }

    public T update(T entity) {
        var entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.merge(entity);
        entityTransaction.commit();

        return entity;
    }

    public void delete(I id) {
        var entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        var entity = read(id);
        entityManager.remove(entity);

        entityTransaction.commit();
    }

}
