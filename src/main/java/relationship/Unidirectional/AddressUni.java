package relationship.Unidirectional;


import javax.persistence.*;

@Entity
@Table(name = "student_address_uni")
public class AddressUni {

    @Id
    @GeneratedValue
    private int address_id;

    @Column(name = "city")
    private String city;

    public AddressUni() {}

    public AddressUni(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
