package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLDAOFactory extends DAOFactory {

    public static EntityManager getEntityManager() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_kiril");
        return factory.createEntityManager();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return new MySQLStudentDAO();
    }

    @Override
    public AddressDAO getAddressDAO() {
        return new MySQLAddressDAO();
    }
}