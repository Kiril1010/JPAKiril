package relationship.strategy_for_generation_ids;

import kiril.EntityManagerTool;

import javax.persistence.*;

@Entity
@Table(name = "student_uni_str")
@SequenceGenerator(name = "student_gen", sequenceName = "student_seq_gen", initialValue = 5, allocationSize = 40)
public class StudentUni {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "student_address_id")
    private AddressUni addressUni;

    public StudentUni(String name) {
        this.name = name;
    }

    public StudentUni() {
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
        EntityManager entityManager = EntityManagerTool.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        AddressUni addressUni = new AddressUni("Kiev");
        StudentUni studentUni = new StudentUni("Jim");
        addressUni.setStudent(studentUni);
        studentUni.setAddressUni(addressUni);

        entityManager.persist(studentUni);
        entityManager.persist(addressUni);

        System.out.println("Before tran");

        transaction.commit();

        entityManager.close();
    }
}
