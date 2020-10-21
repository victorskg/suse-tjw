package ifce.tjw.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

    @Produces
    @PersistenceContext
    private EntityManager entityManager;

}
