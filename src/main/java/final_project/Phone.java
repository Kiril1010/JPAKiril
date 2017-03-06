package final_project;

import javax.persistence.*;

@Entity
@Table(name = "telephone_numbers")
public class Phone {

    @Id
    @GeneratedValue
    private int telephoneNumber_id;

    @Column(name = "telephone_number")
    private int telephoneNumber;
}
