package inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Car bmw = new Bmw("BMW", "5");
        Car merc = new Mercedes("Vito", 4);
//        Car car  = new Car("Some model");

        entityManager.persist(bmw);
//        entityManager.persist(car);
        entityManager.persist(merc);

        transaction.commit();
        entityManager.close();
    }
}
