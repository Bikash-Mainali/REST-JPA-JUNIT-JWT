package com.datum.student.repository;

import com.datum.student.domain.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.datum.student.domain.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT new com.datum.student.domain.StudentDto(s.firstName,s.middleName,s.lastName,s.dateOfBirth,s.gender) from Student s")
    public List<StudentDto> findStudents();

    public Optional<Student> findByCitizenshipNo(String citizenshipNo);
}