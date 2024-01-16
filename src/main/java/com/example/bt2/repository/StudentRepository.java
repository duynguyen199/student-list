package com.example.bt2.repository;

import com.example.bt2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select s from Student s where upper( s.name) like upper(concat('%',?1, '%')) or upper(s.address) like upper(concat('%', ?1,'%') ) ")
    List<Student> findStudentsByNameContaining(String name);

    List<Student> findStudentsById(Long id);
    @Query("select s " +
        "from Student s " +
            "where upper(s.name) like upper(concat('%', ?1, '%')) "+
            "or upper(s.address ) like upper(concat('%', ?2, '%')) "+
            "or upper(s.school) like upper(concat('%', ?3, '%'))"
    )
    List <Student> getStudentsByNameAndSchoolAndAddressContaining
            (String name,String address ,String school);

    @Query("select s  " +
            "from Student s " +
            "where s.name is null or  upper(s.name) like upper(concat('%', ?1, '%')) "+
            "or s.address is null or upper(s.address ) like upper(concat('%', ?2, '%')) "+
            "or s.school is null or upper(s.school) like upper(concat('%', ?3, '%'))"+
            "or s.classStudent is null or upper(s.classStudent) like upper(concat('%', ?3, '%'))"

    )
    List<Student> getStudentsByNameOrAddressOrSchoolOrClassStudentContaining(String name, String address,String school,String classStudent);
}
