package final_project.domain;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "address")
    @JoinColumn(name = "address")
    private Author author;

    public Address() {}

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
