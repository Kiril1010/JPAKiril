package inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "mercedes")
public class Mercedes extends Car {

    private int countOfDoors;

    public Mercedes(String model, int countOfDoors) {
        super(model);
        this.countOfDoors = countOfDoors;
    }

    public int getCountOfDoors() {
        return countOfDoors;
    }

    public void setCountOfDoors(int countOfDoors) {
        this.countOfDoors = countOfDoors;
    }
}
