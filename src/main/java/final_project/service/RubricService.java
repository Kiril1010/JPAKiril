package final_project.service;

import final_project.domain.Advertisement;
import final_project.domain.Rubric;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RubricService implements PersistService<Rubric>{
    private List<Rubric> rubrics;

    public RubricService() {
        rubrics = new ArrayList<>();
    }


    public void addRubric(String name) {
        Rubric rubric1 = new Rubric(name);
        rubrics.add(rubric1);
        save(rubric1);
    }

    public void deleteRubric(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Rubric rubric = entityManager.find(Rubric.class, id);
        entityManager.remove(rubric);

        transaction.commit();
        entityManager.close();
    }

    public void showAdvertisementsFromRubric(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Rubric rubric = entityManager.find(Rubric.class, id);
        List<Advertisement> advertisements = rubric.getAdvertisements();
        advertisements.stream().forEach(adv -> System.out.println(adv.getName()));

        transaction.commit();
        entityManager.close();
    }
}
