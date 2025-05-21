package com.example.CRUD_springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.CRUD_springBoot.model.Student;
import com.example.CRUD_springBoot.repository.StudentRepository;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    } 

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(long id) {
        return studentRepository.findById(id);
        
    }

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    } 

    public Optional<Student> update(Long id, Student updateStudent) {
        return studentRepository.findById(id).map(existing -> {
            existing.setFirstName(updateStudent.getFirstName());
            existing.setLastName(updateStudent.getLastName());
            existing.setAge((updateStudent.getAge()));
            return studentRepository.save(existing);
        });
    }

}
