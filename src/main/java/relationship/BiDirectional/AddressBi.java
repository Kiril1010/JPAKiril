package relationship.BiDirectional;


import javax.persistence.*;

@Entity
@Table(name = "student_address_bi")
public class AddressBi {

    @Id
    @GeneratedValue
    private int address_id;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "addressBi")
    private StudentBi studentBi;

    public AddressBi() {}

    public AddressBi(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StudentBi getStudentBi() {
        return studentBi;
    }

    public void setStudentBi(StudentBi studentBi) {
        this.studentBi = studentBi;
    }
}
