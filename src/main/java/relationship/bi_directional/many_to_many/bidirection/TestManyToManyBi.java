package relationship.bi_directional.many_to_many.bidirection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;


public class TestManyToManyBi {
    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PersonBi personBi1 = new PersonBi("Some personBi1");
        PersonBi personBi2 = new PersonBi("Some personBi2");
        BigDogBi bigDogBi1 = new BigDogBi("Sam");
        BigDogBi bigDogBi2 = new BigDogBi("Captain");
        BigDogBi bigDogBi3 = new BigDogBi("Solli");

        List<PersonBi> personBis = Arrays.asList(personBi1, personBi2);
        bigDogBi1.setPersonBis(personBis);
        bigDogBi2.setPersonBis(personBis);
        bigDogBi3.setPersonBis(personBis);

        List<BigDogBi> bigDogUnis = Arrays.asList(bigDogBi1, bigDogBi2, bigDogBi3);
        personBi1.setBigDogUnis(bigDogUnis);
        personBi2.setBigDogUnis(bigDogUnis);

        entityManager.persist(personBi1);
        entityManager.persist(personBi2);
        entityManager.persist(bigDogBi1);
        entityManager.persist(bigDogBi2);
        entityManager.persist(bigDogBi3);

        transaction.commit();
        entityManager.close();

    }
}
