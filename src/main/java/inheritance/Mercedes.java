package inheritance;

import javax.persistence.Entity;

@Entity
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
