package kiril;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Embeddable
public class Region implements Serializable {

    @Column(name = "count_of_citizens")
    private int countOfCitizens;

    @Column(name = "name_of_city")
    private String name;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    public Region() {
    }

    public Region(int countOfCitizens, String name, State state) {
        this.countOfCitizens = countOfCitizens;
        this.name = name;
        this.state = state;
    }

    public int getCountOfCitizens() {
        return countOfCitizens;
    }

    public void setCountOfCitizens(int countOfCitizens) {
        this.countOfCitizens = countOfCitizens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Region{" +
                "countOfCitizens=" + countOfCitizens +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
