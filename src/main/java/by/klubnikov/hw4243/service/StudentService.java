package by.klubnikov.hw4243.service;

import by.klubnikov.hw4243.entity.Student;
import by.klubnikov.hw4243.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements CrudRepository<Student, Integer> {

    private final CrudRepository<Student, Integer> repository;

    @Override
    public Student save(Student entity) {
        repository.save(entity);
        return entity;
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
