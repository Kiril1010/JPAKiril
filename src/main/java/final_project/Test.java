package final_project;

import final_project.domain.*;
import final_project.service.AdvertisementService;
import final_project.service.RubricService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        /*
        * Вынести получение менеджера в сервис
        * ДАО
        * пакеты
        * */

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_kiril");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Rubric rubricAutoSale = new Rubric("Auto sale");
        Rubric rubricElectronic = new Rubric("Electronic");

        Address addressKiril = new Address("Kharkov");
        Address addressDima = new Address("Kiev");
        Address addressTimur = new Address("Dnepr");

        Email emailKiril = new Email("kiril@gmail.com");
        Email emailDima = new Email("dima@gmail.com");
        Email emailTimur = new Email("timur@gmail.com");

        Phone phoneKirilMTS = new Phone("0508734117");
        Phone phoneKirilKievstar = new Phone("0679500550");
        Phone phoneDimaMTS = new Phone("0505050505");
        Phone phoneDimaKievstar = new Phone("0675050505");
        Phone phoneTimurMTS = new Phone("0999219933");
        Phone phoneTimurKievstar = new Phone("06799219933");

        List<Email> emailsKiril = Arrays.asList(emailKiril);
        List<Email> emailsDima = Arrays.asList(emailDima);
        List<Email> emailsTimur = Arrays.asList(emailTimur);

        List<Phone> phonesKiril = Arrays.asList(phoneKirilMTS, phoneKirilKievstar);
        List<Phone> phonesDima = Arrays.asList(phoneDimaMTS, phoneDimaKievstar);
        List<Phone> phonesTimur = Arrays.asList(phoneTimurMTS, phoneTimurKievstar);

        Date date = new Date();

        Author authorKiril = new Author("Kiril", addressKiril, emailsKiril, phonesKiril);
        Author authorDima = new Author("Dima", addressDima, emailsDima, phonesDima);
        Author authorTimur = new Author("Timur", addressTimur, emailsTimur, phonesTimur);

        Advertisement advertisementOne = new Advertisement("Adv1", date, "Sell BMW X5",
                45.500, authorKiril, rubricAutoSale);
        Advertisement advertisementTwo = new Advertisement("Adv2", date, "Sell Mercedes S500",
                55.500, authorKiril, rubricAutoSale);
        Advertisement advertisementThree = new Advertisement("Adv3", date, "Bye Maybach",
                65.500, authorKiril, rubricAutoSale);
        Advertisement advertisementFour = new Advertisement("Adv4", date, "Sell Audi Q5",
                22.550, authorDima, rubricAutoSale);
        Advertisement advertisementFive = new Advertisement("Adv5", date, "Sell Volvo XC60",
                60.125, authorDima, rubricAutoSale);
        Advertisement advertisementSix = new Advertisement("Adv6", date, "Bye TV Samsung",
                300, authorDima, rubricElectronic);
        Advertisement advertisementSeven = new Advertisement("Adv7", date, "Sell TV Sony",
                450, authorTimur, rubricElectronic);
        Advertisement advertisementEight = new Advertisement("Adv8", date, "Bye Dodje Viper",
                52.125, authorTimur, rubricAutoSale);
        Advertisement advertisementNine = new Advertisement("Adv9", date, "Sell Maybach",
                65.255, authorTimur, rubricAutoSale);
        Advertisement advertisementTen = new Advertisement("Adv10", date, "Sell SELL",
                68, authorTimur, rubricAutoSale);

        rubricAutoSale.setAdvertisements(Arrays.asList(advertisementOne, advertisementTwo, advertisementThree,
                advertisementFour, advertisementFive, advertisementSix, advertisementSeven, advertisementEight,
                advertisementNine, advertisementTen));
        entityManager.persist(rubricElectronic);
        entityManager.persist(authorKiril);
        entityManager.persist(authorDima);
        entityManager.persist(authorTimur);
        entityManager.persist(advertisementOne);

        transaction.commit();
        entityManager.close();

        AdvertisementService service1 = new AdvertisementService();
//        Advertisement advertisementEleven = new Advertisement("Adv11", date, "Sell eleven",
//                111, authorTimur, rubricAutoSale);
//        service1.createNewAdvertisement(advertisementEleven, 12, authorTimur);
////
////        authorKiril.setName("NewAuthor");
//        service1.changeAdvertisement(advertisementOne.getId(), "Changed adv", date, "I change this adv",
//                10000, authorKiril, rubricElectronic);
//
//        service1.deleteAdvertisement(advertisementTen.getId());
//
        RubricService rubricService = new RubricService();
//        rubricElectronic.setAdvertisements(Arrays.asList(advertisementSix, advertisementSeven));
//        advertisementSix.setRubric(rubricElectronic);
//        advertisementSeven.setRubric(rubricElectronic);
//        rubricService.deleteRubric(rubricElectronic.getId());

        service1.deleteAllAdvertisementsByAuthor(authorKiril);

//        rubricService.showAdvertisementsFromRubric(54);
    }
}
