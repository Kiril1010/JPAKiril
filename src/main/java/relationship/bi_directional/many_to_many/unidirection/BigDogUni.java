package relationship.bi_directional.many_to_many.unidirection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "big_dog_uni")
public class BigDogUni {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    public BigDogUni(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
