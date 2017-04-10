package dao;


public interface StudentDAO<T> {

    T getStudentById(int id);

    void saveStudent(T student);
}
