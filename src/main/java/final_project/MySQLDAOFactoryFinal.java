package final_project;

import final_project.service.PersistService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLDAOFactoryFinal extends DAOFactoryFinal {

    public static EntityManager getEntityManager() {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_kiril");
        return factory.createEntityManager();
    }


}
