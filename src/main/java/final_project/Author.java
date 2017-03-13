package final_project;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_fk_id")
    private Address address;

    @OneToMany(mappedBy = "author")
    private List<Email> emails;

    @OneToMany(mappedBy = "author")
    private List<Phone> phones;

    @OneToMany(mappedBy = "author")
    private List<Advertisement> advertisement;

    public Author(String dima, Address addressDima, Email emailDima, Phone phoneDima) {}

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