package relationship.bi_directional.one_to_one_bi;

import kiril.EntityManagerTool;

import javax.persistence.*;

@Entity
@Table(name = "student_bi")

public class StudentBi {

    @Id
    @GeneratedValue
    private int student_id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "student_address_id")
    private AddressBi addressBi;

    public StudentBi() {}

    public StudentBi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressBi getAddressBi() {
        return addressBi;
    }

    public void setAddressBi(AddressBi addressBi) {
        this.addressBi = addressBi;
    }

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerTool.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        AddressBi addressBi = new AddressBi("Kharkov");
        StudentBi studentBi = new StudentBi("Kiril");
        addressBi.setStudentBi(studentBi);
        studentBi.setAddressBi(addressBi);

        entityManager.persist(studentBi);
        entityManager.persist(addressBi);

        transaction.commit();
        entityManager.close();
    }
}
