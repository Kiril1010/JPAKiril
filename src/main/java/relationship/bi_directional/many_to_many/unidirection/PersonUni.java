package relationship.bi_directional.many_to_many.unidirection;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "person_uni")
public class PersonUni {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
            @JoinTable(name = "person_dog_uni",
                    joinColumns = @JoinColumn(name = "person_uni_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_uni_id"))
    List<BigDogUni> bigDogUnis;

    public PersonUni() {}

    public PersonUni(String lastName) {
        this.lastName = lastName;
    }

    public List<BigDogUni> getBigDogUnis() {
        return bigDogUnis;
    }

    public void setBigDogUnis(List<BigDogUni> bigDogUnis) {
        this.bigDogUnis = bigDogUnis;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
