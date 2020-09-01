package com.datum.student.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.datum.student.domain.Student;
import com.datum.student.domain.StudentDto;

public interface StudentService {
	public List<Student> findAll();
	public Map<String,List<StudentDto>> genderMapper();
	public void save(Student student);
    public Optional<Student> findByCitizenshipNo(String citizenshipNo);
	public void delete(Long id);
	public Optional<Student> findById(Long id);
	public Map<String,Integer> countMapper(String data);
	public void readFile() throws IOException;

}
