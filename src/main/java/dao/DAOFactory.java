package dao;

public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int NOSQL = 2;


    public abstract StudentDAO getStudentDAO();

    public abstract AddressDAO getAddressDAO();

    public static DAOFactory getDAOFactory(int factoryId) {
        switch (factoryId) {
            case 1:
                return new MySQLDAOFactory();
            case 2:
                return new NoSQLDAOFactory();

            default:
                return null;
        }
    }
}
