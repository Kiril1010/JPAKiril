package final_project;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "email_fk_id")
    private Author author;

    public Email() {}

    public Email(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
