package dao;

import relationship.unidirectional.StudentUni;

public class TestDAO {

    public static void main(String[] args) {
//        DAOFactory mysqlDao = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//        StudentDAO<StudentUni> studentDAO = mysqlDao.getStudentDAO();
//
//        StudentUni student = new StudentUni("Students");
//
//        studentDAO.saveStudent(student);
//
//        StudentUni studentFromDb = studentDAO.getStudentById(1);
//
//        System.out.println(studentFromDb.getName());
//        MySQLDAOFactory.getEntityManager().close();

    DAOFactory nosqlDAO = DAOFactory.getDAOFactory(DAOFactory.NOSQL);
    StudentDAO<StudentUni> studentDAO = nosqlDAO.getStudentDAO();

    StudentUni student = new StudentUni("Boris");

        studentDAO.saveStudent(student);
        StudentUni studentFromDB = studentDAO.getStudentById(1);

        System.out.println(studentFromDB.getName());
        NoSQLDAOFactory.getEntityManager().close();
    }
 }