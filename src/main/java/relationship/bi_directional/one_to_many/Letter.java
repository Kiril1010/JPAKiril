package relationship.bi_directional.one_to_many;

import javax.persistence.*;

@Entity
@Table(name = "letter")
public class Letter {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "text")
    private String text;

    public Letter() {
    }

    @ManyToOne
    @JoinColumn(name = "letter_email_fk")
    private EmailBidirectional email;

    public Letter(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EmailBidirectional getEmail() {
        return email;
    }

    public void setEmail(EmailBidirectional email) {
        this.email = email;
    }
}

