package final_project;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "rubric")
public class Rubric {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "rubric")
    @Column(name = "rubric")
    private List<Advertisement> rubrics;

    public Rubric() {}

    public Rubric(String name) {
        this.name = name;
        this.rubrics = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAdvert(Advertisement advertisement) {
        rubrics.add(advertisement);
    }

    public List<Advertisement> getRubrics() {
        return rubrics;
    }

    public void setRubrics(List<Advertisement> rubrics) {
        this.rubrics = rubrics;
    }
}
