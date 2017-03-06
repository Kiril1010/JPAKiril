package kiril;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTool {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static EntityManager getSingletonEntityManafer() {
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
