package final_project;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = Email.email_id, sequenceName = Email.email_id, initialValue = 1, allocationSize = 50)
@Table(name = "email")
public class Email {

    public static final String email_id = "email_id";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = email_id)
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
