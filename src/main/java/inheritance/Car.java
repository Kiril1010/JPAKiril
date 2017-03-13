package inheritance;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "model_car")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Car {
//public  class Car {

    @Id
    @GeneratedValue
    private int id;

    private String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
