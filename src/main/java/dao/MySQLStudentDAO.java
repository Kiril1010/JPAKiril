package dao;

import relationship.unidirectional.StudentUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MySQLStudentDAO implements StudentDAO<StudentUni> {

    @Override
    public StudentUni getStudentById(int id) {
        EntityManager entityManager = MySQLDAOFactory.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        StudentUni student = entityManager.find(StudentUni.class, id);

        transaction.commit();
        return student;
    }

    @Override
    public void saveStudent(StudentUni student) {
        EntityManager entityManager = MySQLDAOFactory.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(student);

        transaction.commit();
    }
}
