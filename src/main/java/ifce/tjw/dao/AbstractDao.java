package ifce.tjw.dao;

import ifce.tjw.model.EntidadeBase;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends EntidadeBase<I>, I extends Number> {

    private static final String INSTANCE = " e";
    private static final String SELECT_ALL = "SELECT e FROM ";

    private Class<T> entityClass() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    protected abstract EntityManager entityManager();

    @Transactional
    public T create(T entity) {
        entityManager().persist(entity);
        return entity;
    }

    public T read(I id) {
        return entityManager().find(entityClass(), id);
    }

    public List<T> readAll() {
        return entityManager()
                .createQuery(SELECT_ALL + entityClass().getSimpleName() + INSTANCE)
                .getResultList();
    }

    @Transactional
    public void update(T entity) {
        entityManager().merge(entity);
    }

    @Transactional
    public void delete(I id) {
        var entity = read(id);
        entityManager().remove(entity);
    }
}
