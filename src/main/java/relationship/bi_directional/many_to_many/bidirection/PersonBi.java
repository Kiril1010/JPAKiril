package relationship.bi_directional.many_to_many.bidirection;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person_bi")
public class PersonBi {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
            @JoinTable(name = "person_dog_bi",
                    joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "dog_id"))
    List<BigDogBi> bigDogBis;

    public PersonBi() {}

    public PersonBi(String lastName) {
        this.lastName = lastName;
    }

    public List<BigDogBi> getBigDogUnis() {
        return bigDogBis;
    }

    public void setBigDogUnis(List<BigDogBi> bigDogUnis) {
        this.bigDogBis = bigDogUnis;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
