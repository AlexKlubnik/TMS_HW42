package by.klubnikov.hw4243.repository;

import by.klubnikov.hw4243.entity.Student;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StudentRepo implements CrudRepository<Student, Integer> {

    private final SessionFactory factory;

    @Override
    public Student save(Student student) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (student.getId() == null) {
                session.persist(student);
            } else {
                session.merge(student);
            }
            transaction.commit();
        }
        return student;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        Student student = null;
        try (Session session = factory.openSession()) {
            student = session.find(Student.class, id);
        }
        return Optional.ofNullable(student);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students;
        try (Session session = factory.openSession()) {
            students = session
                    .createQuery("from Student", Student.class)
                    .getResultList();
        }
        return students;
    }

    @Override
    public void delete(Integer id) {
        try (Session session = factory.openSession()) {
    Transaction transaction = session.beginTransaction();
    findById(id).ifPresent(student -> session.remove(student));
    transaction.commit();
        }
    }
}
