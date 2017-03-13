package relationship.strategy_for_generation_ids;

import javax.persistence.*;

@Entity
@Table(name = "students_address_uni_str")
@SequenceGenerator(name = "address_gen", sequenceName = "address_seq_gen", initialValue = 6, allocationSize = 40)
public class AddressUni {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")

    private int id;

    @Column(name = "city")
    private String city;


    @OneToOne(mappedBy = "addressUni")
    /*@OneToOne
    @JoinColumn(name = "address_student_id")*/
            StudentUni student;

    public AddressUni(String city) {
        this.city = city;
    }

    public AddressUni() {
    }

    public void setStudent(StudentUni student) {
        this.student = student;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
