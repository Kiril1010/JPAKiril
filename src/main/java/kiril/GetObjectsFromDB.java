package kiril;

import javax.persistence.*;
import java.util.List;

public class GetObjectsFromDB {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

//        Person person = entityManager.find(Person.class, 2);
//        Person person = entityManager.getReference(Person.class, 3);
//        person.setName("Borya");
//        System.out.println(person.getName() );
//        System.out.println(person.toString() );
//        entityManager.remove(person);

//        List<Person> listOfPerson = entityManager.createQuery("FROM Person").getResultList();
//        listOfPerson.stream().forEach(System.out::println);

//        List<Object[]> listOfPerson = entityManager.createQuery("SELECT p.name, p.date FROM Person p").getResultList();
//        List<Object[]> listOfPerson = entityManager.createQuery(("SELECT p FROM Person p WHERE p.region.countOfCitizens = 150")).getResultList();
//        listOfPerson.stream().forEach(System.out::println);
//
//        Person person = (Person) entityManager.createQuery("SELECT p FROM Person p WHERE p.region.countOfCitizens = 150").getSingleResult();
//        System.out.println();


        Query getAllPersons = entityManager.createNamedQuery("getAllPersons");
        List<Object[]> listOfPersons = getAllPersons.getResultList();

        Query getAllPerson = entityManager.createNamedQuery("getCountOfCitizens");
        getAllPerson.setParameter("count", 135);
        Object singleResult = getAllPerson.getSingleResult();

        System.out.println();

        entityTransaction.commit();
        entityManager.close();

    }
}
