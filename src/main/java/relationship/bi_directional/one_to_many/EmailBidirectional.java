package relationship.bi_directional.one_to_many;

import relationship.bi_directional.one_to_many.EmailBidirectional;
import kiril.EntityManagerTool;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "email")
public class EmailBidirectional {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "email_address")
    private String name;

    @OneToMany(mappedBy = "email", cascade = {CascadeType.PERSIST, CascadeType.DETACH},
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Letter> letters;

    public EmailBidirectional() {}

    public EmailBidirectional(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerTool.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Letter letter1 = new Letter("Hello");
        Letter letter2 = new Letter("World");
        Letter letter3 = new Letter("Bye");

        List<Letter> list = Arrays.asList(letter1, letter2, letter3);
        EmailBidirectional email = new EmailBidirectional("gmail.com");
        EmailBidirectional email2 = new EmailBidirectional("mail.ru");

        email.setLetters(list);
        email2.setLetters(list);

        letter1.setEmail(email);
        letter2.setEmail(email2);
        letter3.setEmail(email);

       /* entityManager.persist(letter1);
        entityManager.persist(letter2);
        entityManager.persist(letter3);*/

    /*    entityManager.persist(email);
        entityManager.persist(email2);*/

        transaction.commit();

        transaction.begin();

        EmailBidirectional emailBidirectional = entityManager.find(EmailBidirectional.class, 11L);

        System.out.println();

//        emailBidirectional.getLetters().remove(0);
//        emailBidirectional.getLetters().clear();

        transaction.commit();
        entityManager.close();
    }
}

