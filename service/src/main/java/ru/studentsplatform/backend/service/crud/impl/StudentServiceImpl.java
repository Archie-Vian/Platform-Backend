package ru.studentsplatform.backend.service.crud.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import ru.studentsplatform.backend.entities.model.Student;
import ru.studentsplatform.backend.repository.StudentRepository;
import ru.studentsplatform.backend.service.crud.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student newEntity) {
        return studentRepository.saveAndFlush(newEntity);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Student updatedEntity, Long id) {
        updatedEntity.setId(id);
        return studentRepository.saveAndFlush(updatedEntity);
    }

    @Override
    public boolean delete(Long id) {
        try {
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        return true;
    }
}