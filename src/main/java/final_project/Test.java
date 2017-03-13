package final_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {

    static RubricService rubricService = new RubricService();
    public static void getMenu() {
        Scanner scannerMenu = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to add new rubric");
        System.out.println("Enter 2 to add new advertisement");
        String key = scannerMenu.nextLine();
        while (true) {
            switch (key) {
                case "1": {
                    System.out.println("Enter the name of rubric");
                    String nameRubric = scanner.nextLine();
                    rubricService.addRubric(nameRubric);
                    break;
                }
                case "2": {
                    System.out.println("Enter the name of advertisement");
                    String nameAdvertisement = scanner.nextLine();
                    rubricService.addRubric(nameAdvertisement);
                    break;
                }
            } break;
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.getMenu();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
//        Rubric rubricAutoSale = new Rubric("Auto sale");
//        Rubric rubricElectronic = new Rubric("Electronic");
//
//        Address addressKiril = new Address("Kharkov");
//        Address addressDima = new Address("Kiev");
//        Address addressTimur = new Address("Dnepr");
//
//        Email emailKiril = new Email("kiril@gmail.com");
//        Email emailDima = new Email("dima@gmail.com");
//        Email emailTimur = new Email("timur@gmail.com");
//
//        Phone phoneKirilMTS = new Phone("0508734117");
//        Phone phoneKirilKievstar = new Phone("0679500550");
//        Phone phoneDimaMTS = new Phone("0505050505");
//        Phone phoneDimaKievstar = new Phone("0675050505");
//        Phone phoneTimurMTS = new Phone("0999219933");
//        Phone phoneTimurKievstar = new Phone("06799219933");
//
//        List<Email> emailsKiril = Arrays.asList(emailKiril);//new int[]{1,2,3}
//        List<Email> emailsDima = Arrays.asList(emailDima);
//        List<Email> emailsTimur = Arrays.asList(emailTimur);
//
//        List<Phone> phonesKiril = Arrays.asList(phoneKirilMTS, phoneKirilKievstar);
//        List<Phone> phonesDima = Arrays.asList(phoneDimaMTS, phoneDimaKievstar);
//        List<Phone> phonesTimur = Arrays.asList(phoneTimurMTS, phoneTimurKievstar);
//
//        Date date = new Date();
//
//        Author authorKiril = new Author("Kiril", addressKiril, emailsKiril, phonesKiril);
//        Author authorDima = new Author("Dima", addressDima, emailsDima, phonesDima);
//        Author authorTimur = new Author("Timur", addressTimur, emailsTimur, phonesTimur);
//
//        Advertisement advertisementOne = new Advertisement( "Adv1", date, "Sell BMW X5",
//                45.000, authorKiril,   rubricAutoSale);
//        Advertisement advertisementTwo = new Advertisement( "Adv2", date, "Sell Mercedes S500",
//                55.000, authorKiril,   rubricAutoSale);
//        Advertisement advertisementThree = new Advertisement("Adv3", date, "Bye Maybach",
//                65.000, authorKiril,   rubricAutoSale);
//        Advertisement advertisementFour = new Advertisement( "Adv4", date, "Sell Audi Q5",
//                22.000,  authorDima, rubricAutoSale);
//        Advertisement advertisementFive = new Advertisement(  "Adv5", date, "Sell Volvo XC60",
//                60.000, authorDima,  rubricAutoSale);
//        Advertisement advertisementSix = new Advertisement(   "Adv6", date, "Bye TV Samsung",
//                300,    authorDima, rubricElectronic);
//        Advertisement advertisementSeven = new Advertisement("Adv7", date, "Sell TV Sony",
//                450,     authorTimur, rubricElectronic);
//        Advertisement advertisementEight = new Advertisement( "Adv8", date, "Bye Dodje Viper",
//                52.000, authorTimur,  rubricAutoSale);
//        Advertisement advertisementNine = new Advertisement( "Adv9", date, "Sell Maybach",
//                65.000, authorTimur, rubricAutoSale);
//
//        addressKiril.setAuthor(authorKiril);
//        addressDima.setAuthor(authorDima);
//        addressTimur.setAuthor(authorTimur);
//
//        emailKiril.setAuthor(authorKiril);
//        emailDima.setAuthor(authorDima);
//        emailTimur.setAuthor(authorTimur);
//
//        phoneKirilMTS.setAuthor(authorKiril);
//        phoneKirilKievstar.setAuthor(authorKiril);
//        phoneDimaMTS.setAuthor(authorDima);
//        phoneDimaKievstar.setAuthor(authorDima);
//        phoneTimurMTS.setAuthor(authorTimur);
//        phoneTimurKievstar.setAuthor(authorTimur);
//
//        entityManager.persist(rubricAutoSale);
//        entityManager.persist(rubricElectronic);
//        entityManager.persist(addressKiril);
//        entityManager.persist(addressDima);
//        entityManager.persist(addressTimur);
//        entityManager.persist(emailKiril);
//        entityManager.persist(emailDima);
//        entityManager.persist(emailTimur);
//        entityManager.persist(phoneKirilMTS);
//        entityManager.persist(phoneKirilKievstar);
//        entityManager.persist(phoneDimaMTS);
//        entityManager.persist(phoneDimaKievstar);
//        entityManager.persist(phoneTimurMTS);
//        entityManager.persist(phoneTimurKievstar);
//        entityManager.persist(authorKiril);
//        entityManager.persist(authorDima);
//        entityManager.persist(authorTimur);
//        entityManager.persist(advertisementOne);
//        entityManager.persist(advertisementTwo);
//        entityManager.persist(advertisementThree);
//        entityManager.persist(advertisementFour);
//        entityManager.persist(advertisementFive);
//        entityManager.persist(advertisementSix);
//        entityManager.persist(advertisementSeven);
//        entityManager.persist(advertisementEight);
//        entityManager.persist(advertisementNine);
        entityManager.persist(menu);
        entityManager.persist(rubricService);

        transaction.commit();
        entityManager.close();
    }
}
