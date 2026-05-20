package com.re.ss6exam.service.impl;

import com.re.ss6exam.model.entity.Student;
import com.re.ss6exam.repository.StudentRepository;
import com.re.ss6exam.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy học sinh có id = " + id));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateFull(Long id, Student student) {
        Student oldStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Không tìm thấy học sinh có id = " + id));

        oldStudent.setFullName(student.getFullName());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setGpa(student.getGpa());

        return studentRepository.save(oldStudent);
    }

    @Override
    public Student updatePartial(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Không tìm thấy học sinh có id = " + id));

        if (updates.containsKey("fullName")) {
            student.setFullName((String) updates.get("fullName"));
        }

        if (updates.containsKey("email")) {
            student.setEmail((String) updates.get("email"));
        }

        if (updates.containsKey("gpa")) {
            student.setGpa(Double.valueOf(updates.get("gpa").toString()));
        }

        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy học sinh có id = " + id));
        studentRepository.deleteById(id);
        return true;
    }
}
