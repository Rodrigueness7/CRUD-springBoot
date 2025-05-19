package com.example.CRUD_springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD_springBoot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

}