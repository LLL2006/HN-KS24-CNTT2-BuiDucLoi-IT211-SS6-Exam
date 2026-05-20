package com.re.ss6exam.service;

import com.re.ss6exam.model.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student addStudent(Student student);

    Student updateFull(Long id, Student student);

    Student updatePartial(Long id, Map<String, Object> updates);

    boolean deleteStudent(Long id);
}
