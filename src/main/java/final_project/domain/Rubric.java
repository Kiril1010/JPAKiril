package final_project.domain;

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

    @OneToMany(mappedBy = "rubric", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Column(name = "rubric_table")
    private List<Advertisement> advertisements;

    public Rubric() {}

    public Rubric(String name) {
        this.name = name;
        this.advertisements = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAdvert(Advertisement advertisement) {
        advertisements.add(advertisement);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public int getId() {
        return id;
    }
}
