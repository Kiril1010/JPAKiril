package relationship.unidirectional;

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

    @OneToOne(cascade = CascadeType.ALL)
//    @OneToOne
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

        StudentUni studentUni = new StudentUni("Kiril");
        AddressUni addressUni = new AddressUni("Kharkov");
        studentUni.setAddressUni(addressUni);
        addressUni.setStudentUni(studentUni);

//        entityManager.persist(addressUni);
//        entityManager.persist(studentUni);

        transaction.commit();
        transaction.begin();
//        AddressUni address = entityManager.find(AddressUni.class, 1);
        StudentUni studentUni1 = entityManager.find(StudentUni.class, 3);
        entityManager.remove(studentUni1);
        transaction.commit();
        entityManager.close();
    }
}
