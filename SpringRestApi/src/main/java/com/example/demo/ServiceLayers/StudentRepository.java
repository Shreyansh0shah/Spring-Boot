package com.example.demo.ServiceLayers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Student;

public interface StudentRepository extends JpaRepository<Student , Integer>{

}
