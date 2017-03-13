package dao;

import relationship.unidirectional.StudentUni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class NoSQLStudentDAO implements StudentDAO<StudentUni>{

    @Override
    public StudentUni getStudentById(int id) {
        EntityManager entityManager = NoSQLDAOFactory.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        StudentUni studentUni = entityManager.find(StudentUni.class, 1);

        transaction.commit();
        return studentUni;
    }

    @Override
    public void saveStudent(StudentUni student) {
        EntityManager entityManager = NoSQLDAOFactory.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(student);
        transaction.commit();
    }
}
