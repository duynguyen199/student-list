package com.example.bt2.controller;

import com.example.bt2.model.Student;
import com.example.bt2.service.StudentService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<?> createStudent(String name, String address,String school){
        Student student= studentService.createStudent(name,address,school);
        return ResponseEntity.ok(student);

    }
    @GetMapping("/all")
    public ResponseEntity<?> getALlStudents(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/id")
    public ResponseEntity<?> getStudentsById(Long id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }
    @GetMapping("/name")
    public ResponseEntity<?> getStudentByNameLike(String name){
        return ResponseEntity.ok(studentService.findStudentByName(name));
    }

    @GetMapping("/nameAddressSchool")
    public ResponseEntity<?> getStudentByNameAddressSchool(String name, String address,String school){
        return ResponseEntity.ok(studentService.findStudentByNameAddressSchool(name,address,school));
    }
    @GetMapping("/list")
    public ResponseEntity<?> getStudent(String name,String address,String school,String classStudent){
        return ResponseEntity.ok(studentService.findStudentBySendParamsOrGetAll(name,address,school,classStudent));
    }

}
