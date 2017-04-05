package final_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class AdvertisementService implements PersistService<Advertisement> {

    public void createNewAdvertisement(Advertisement advertisement, int rubricId, Author author) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Rubric rubric = entityManager.find(Rubric.class, rubricId);
        Author author1 = entityManager.merge(author);
        advertisement.setAuthor(author1);
        advertisement.setRubric(rubric);
        rubric.addAdvert(advertisement);

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

        Author author = entityManager.find(Author.class, id);
        List<Advertisement> advertisements = author.getAdvertisements();
        entityManager.remove(advertisements);

        transaction.commit();
        entityManager.close();
    }
}


