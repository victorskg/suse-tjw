package ifce.tjw.producer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

    private static final EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("TjwPU");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
