package final_project;

import java.util.ArrayList;
import java.util.List;

public class RubricService implements PersistService<Rubric>{
    private List<Rubric> rubrics;

    public RubricService() {
        rubrics = new ArrayList<>();
    }


    public void addRubric(String name) {
        Rubric rubric1 = new Rubric(name);
        rubrics.add(rubric1);
        save(rubric1);
    }
}
