package final_project;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "phones")
    private String phones;

    @ManyToOne
    @JoinColumn(name = "phone")
    private Author author;

    public Phone() {}

    public Phone(String phones) {
        this.phones = phones;
    }

    public String getPhones() {
        return phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
