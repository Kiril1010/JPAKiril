//Создать приложение Доска объявлений.
//        Автор может иметь несколько объявлений в разных рубриках.
//        Приложение должно позволять:
//     +   1) Создавать Рубрику с/без объявлений.
//     +  2) Создавать Объявление(название, дата публикации, текст объявления, стоимость услуги,
//     +   автор(телефоны(отдельная сущность), адрес(отдельная сущность), имя, э/почта(отдельная сущность)).
//        3) Редактировать объявление, личную информацию автора и рубрику.
//        4) Удалять объявление/рубрику.
//        5) Удалять все объявления автора.
//        6) Показывать объявления из одной рубрики и нескольких рубрик.
//
//        В приложении использовать Spring 4, JPA(JPQL, NamedQueries, Criteria queries, lazy initialization)

package final_project;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "text")
    private String text;

    @Column(name = "price")
    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author")
    private Author author;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rubric_id")
    private Rubric rubric;

    public Advertisement() {}

    public Advertisement(String name, Date date, String text, double price, Author author, Rubric rubric) {
        this.name = name;
        this.date = date;
        this.text = text;
        this.price = price;
        this.author = author;
        this.rubric = rubric;
    }

//    public Advertisement(String name, Date date, String text, double price, Author author, Rubric rubric) {
//        this(name, date, text, price, author);
//        this.rubric = rubric;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }
}
