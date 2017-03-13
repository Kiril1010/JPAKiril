package relationship.bi_directional.many_to_many.unidirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;


public class TestManyToManyUni {
    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PersonUni personUni1 = new PersonUni("Some personUni1");
        PersonUni personUni2 = new PersonUni("Some personUni2");
        BigDogUni bigDogUni1 = new BigDogUni("Sam");
        BigDogUni bigDogUni2 = new BigDogUni("Captain");
        BigDogUni bigDogUni3 = new BigDogUni("Solli");

        List<BigDogUni> bigDogUnis = Arrays.asList(bigDogUni1, bigDogUni2, bigDogUni3);
        personUni1.setBigDogUnis(bigDogUnis);
        personUni2.setBigDogUnis(bigDogUnis);

        entityManager.persist(personUni1);
        entityManager.persist(personUni2);
        entityManager.persist(bigDogUni1);
        entityManager.persist(bigDogUni2);
        entityManager.persist(bigDogUni3);

        transaction.commit();
        entityManager.close();

    }
}
