package ifce.tjw.repository;

import ifce.tjw.model.EntidadeBase;

import java.util.List;

public interface CRUDRepository<T extends EntidadeBase<I>, I extends Number> {

    public T create(T entity);

    public T read(I id);

    public List<T> readAll();

    public void update(T entity);

    public void delete(I id);

}
