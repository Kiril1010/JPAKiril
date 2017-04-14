package final_project;

public class DAOFactoryFinal {
    public static final int MYSQL = 1;

    public static MySQLDAOFactoryFinal getDAOFactory(int factoryId) {
        switch (factoryId) {
            case 1:
                return new MySQLDAOFactoryFinal();

            default:
                return null;
        }
    }
}
