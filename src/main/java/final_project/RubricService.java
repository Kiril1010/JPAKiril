package final_project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RubricService {

    @Id
    @GeneratedValue
    private int id;

    public void addRubric(String name) {
        Rubric rubric = new Rubric();
        rubric.setName(name);
    }
}
