package relationship.Unidirectional;

import kiril.EntityManagerTool;

import javax.persistence.*;

@Entity
@Table(name = "student_uni")

public class StudentUni {

    @Id
    @GeneratedValue
    private int student_id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "student_address_id")
    private AddressUni addressUni;

    public StudentUni() {}

    public StudentUni(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressUni getAddressUni() {
        return addressUni;
    }

    public void setAddressUni(AddressUni addressUni) {
        this.addressUni = addressUni;
    }

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerTool.getSingletonEntityManafer();
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        AddressUni addressUni = new AddressUni("Kharkov");
        StudentUni studentUni = new StudentUni("Kiril");
        studentUni.setAddressUni(addressUni);

        entityManager.persist(addressUni);
        entityManager.persist(studentUni);

        transaction.commit();
        entityManager.close();
    }
}
