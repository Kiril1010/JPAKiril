package relationship.bi_directional.many_to_many.bidirection;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "big_dog_bi")
public class BigDogBi {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "bigDogBis")
    List<PersonBi> personBis;

    public List<PersonBi> getPersonBis() {
        return personBis;
    }

    public void setPersonBis(List<PersonBi> personBis) {
        this.personBis = personBis;
    }

    public BigDogBi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
