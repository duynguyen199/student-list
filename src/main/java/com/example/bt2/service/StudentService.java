package com.example.bt2.service;

import com.example.bt2.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Student createStudent(String name, String address,String school);

    List getAllStudent();
    List findStudentById(Long id);
    List findStudentByName(String name);
    List findStudentByNameAddressSchool(String name,String address,String school);

    List<Student> findStudentBySendParamsOrGetAll(String name, String adrress,String school, String classStudent);


}
