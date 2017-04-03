package final_project;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = Author.author_id, sequenceName = Author.author_id, initialValue = 1, allocationSize = 50)
@Table(name = "author")
public class Author {

    public static final String author_id = "author_id";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = author_id)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_fk_id")
    private Address address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Email> emails;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Phone> phones;

    @OneToMany(mappedBy = "author", cascade = CascadeType.PERSIST)
    private List<Advertisement> advertisements;

    public Author() {}

    public Author(String name, Address address, List<Email> emails, List<Phone> phones) {
        this.name = name;
        this.address = address;
        this.emails = emails;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
