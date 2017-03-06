package kiril;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@NamedQueries({
        @NamedQuery(
                name = "getAllPersons",
                query = "FROM Person"
        ),

        @NamedQuery(
                name = "getCountOfCitizens",
//                query = "SELECT p FROM Person p WHERE p.region.countOfCitizens = 150"
                query = "SELECT p FROM Person p WHERE p.region.countOfCitizens = :count"
        )
})

public class Person {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int personId;

    @Column(name = "person_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private Cities city;

    @Temporal(TemporalType.TIMESTAMP)
//    @Temporal(TemporalType.TIME)
//    @Temporal(TemporalType.DATE)
    private Date date;

    @Embedded
    private Region region;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", name='" + name + '\'' + ", city=" + city + ", date=" + date + ", region=" + region + '}';
    }

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person("Kiril Bondarev");
        person.setCity(Cities.KHARKOV);
        person.setDate(new Date());
        Region region = new Region(150, "Dnepr", State.DNEPR);
        person.setRegion(region);

        entityManager.persist(person);
        entityTransaction.commit();
        entityManager.close();

    }
}
