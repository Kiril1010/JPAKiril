//Создать приложение Доска объявлений.
//        Автор может иметь несколько объявлений в разных рубриках.
//        Приложение должно позволять:
//        1) Создавать Рубрику с/без объявлений.
//        2) Создавать Объявление(название, дата публикации, текст объявления, стоимость услуги,
//        автор(телефоны(отдельная сущность), адрес(отдельная сущность), имя, э/почта(отдельная сущность)).
//        3) Редактировать объявление, личную информацию автора и рубрику.
//        4) Удалять объявление/рубрику.
//        5) Удалять все объявления автора.
//        6) Показывать объявления из одной рубрики и нескольких рубрик.
//
//        В приложении использовать Spring 4, JPA(JPQL, NamedQueries, Criteria queries, lazy initialization)

package final_project;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    private static final Scanner scanner = new Scanner(System.in);

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "text")
    private String text;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "rubric_id")
    private Rubric rubric;

    public Advertisement() {}

    public Advertisement(String name, Date date, String text, double price, Author author) {
        this.name = name;
        this.date = date;
        this.text = text;
        this.price = price;
        this.author = author;
    }

    public Advertisement(String name, Date date, String text, double price, Author author, Rubric rubric) {
        this(name, date, text, price, author);
        this.rubric = rubric;
    }

    public void addNewAdvertisement() {
        System.out.println("Please enter the name of advertisement");
        String name = scanner.nextLine();
        System.out.println("Please enter the text of advertisement");
        String text = scanner.nextLine();
        System.out.println("Please enter the price");
        double price = scanner.nextInt();
        Date date = new Date();

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
