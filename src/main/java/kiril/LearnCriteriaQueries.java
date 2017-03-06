package kiril;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LearnCriteriaQueries {

    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerTool.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.select(root);
        TypedQuery<Person> typedQuery = entityManager.createQuery(query);
        List<Person> list = typedQuery.getResultList();

        System.out.println();

        entityTransaction.commit();
        entityManager.close();

    }
}
