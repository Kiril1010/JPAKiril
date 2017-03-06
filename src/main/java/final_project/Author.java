package final_project;

import javax.persistence.*;

@Entity
@Table(name = "authorOfAdvertisement")
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

}