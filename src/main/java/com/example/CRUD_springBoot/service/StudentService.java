package com.example.CRUD_springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.CRUD_springBoot.exception.ResourceNotFindException;
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

    public Student findById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFindException("Student with ID " + id + " not find"));
        
    }

    public Student add(Student student) {
        if(studentRepository.existsByFirstName(student.getFirstName())){
            throw new ResourceNotFindException("Already exist student with these firstName");
        }
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {

        if(!studentRepository.existsById(id)) {
            throw new ResourceNotFindException("Id not found");
        }

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
