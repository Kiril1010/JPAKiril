package final_project;

import javax.persistence.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class AdvertisementService implements PersistService<Advertisement> {

    public void createNewAdvertisement(Advertisement advertisement, int rubricId, Author author) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Rubric rubric = entityManager.find(Rubric.class, rubricId);
        Author author1 = entityManager.merge(author);
        rubric.addAdvert(advertisement);
        advertisement.setAuthor(author1);
        advertisement.setRubric(rubric);

        transaction.commit();
        entityManager.close();
    }

    public void changeAdvertisement(int id, String name, Date date, String text, double price, Author author, Rubric rubric) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Advertisement advertisement = entityManager.find(Advertisement.class, id);
        Author newAuthor = entityManager.merge(author);
        Rubric newRubric = entityManager.merge(rubric);

        advertisement.setName(name);
        advertisement.setDate(date);
        advertisement.setPrice(price);
        advertisement.setText(text);
        advertisement.setAuthor(newAuthor);
        advertisement.setRubric(newRubric);

        transaction.commit();
        entityManager.close();
    }

    public void deleteAdvertisement(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        getEntityFactory();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Advertisement advertisement = entityManager.find(Advertisement.class, id);
        entityManager.remove(advertisement);

        transaction.commit();
        entityManager.close();
    }

    public void deleteAllAdvertisementsByAuthor(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        Author author = entityManager.find(Author.class, id);
//        author.getAdvertisements().clear();
        String query = "FROM Advertisement WHERE author = " + id;
        Query namedQuery = entityManager.createQuery(query);
        List<Advertisement> advertisements = namedQuery.getResultList();
        advertisements.stream().forEach(adv -> entityManager.remove(adv));

        System.out.println();
        transaction.commit();
        entityManager.close();
    }
}


