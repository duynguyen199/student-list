package com.example.bt2.service.imp;

import com.example.bt2.model.Student;
import com.example.bt2.repository.StudentRepository;
import com.example.bt2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student createStudent(String name, String address, String school) {
        return null;
    }

    @Override
    public List getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public List findStudentById(Long id) {
        return studentRepository.findStudentsById(id);
    }

    @Override
    public List findStudentByName(String name) {
        List listStudent=studentRepository.findStudentsByNameContaining(name);

        return listStudent;
    }

    @Override
    public List findStudentByNameAddressSchool(String name, String address, String school) {
        return studentRepository.getStudentsByNameAndSchoolAndAddressContaining(name,address,school);

    }

    @Override
    public List findStudentBySendParamsOrGetAll(String name, String adrress, String school, String classStudent) {
        return studentRepository.getStudentsByNameOrAddressOrSchoolOrClassStudentContaining(name,adrress,school,classStudent);
    }


}
