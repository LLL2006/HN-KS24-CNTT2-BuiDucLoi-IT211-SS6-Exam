package com.re.ss6exam.controller;

import com.re.ss6exam.model.dto.ApiDataResponse;
import com.re.ss6exam.model.entity.Student;
import com.re.ss6exam.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<?>>  getAllStudents() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách thành công",
                studentService.getAllStudents(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> getStudentById(@PathVariable long id) {
        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Lấy danh sách thành công",
                    studentService.getStudentById(id),
                    HttpStatus.OK
            ), HttpStatus.OK);
        }  catch (Exception e) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    false,
                    e.getMessage(),
                    null,
                    HttpStatus.NOT_FOUND
            ), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<?>> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm sinh viên thành công",
                studentService.addStudent(student),
                HttpStatus.CREATED
        ),  HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> updateStudent(@PathVariable long id, @RequestBody Student student) {
        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Cập nhật sinh viên thành công",
                    studentService.updateFull(id, student),
                    HttpStatus.OK
            ), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    false,
                    e.getMessage(),
                    null,
                    HttpStatus.NOT_FOUND
            ), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> patchStudent(@PathVariable long id, @RequestBody Map<String, Object> updates) {
        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Cập nhật một phần sinh viên thành công",
                    studentService.updatePartial(id, updates),
                    HttpStatus.OK
            ), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    false,
                    e.getMessage(),
                    null,
                    HttpStatus.NOT_FOUND
            ), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> deleteStudent(@PathVariable long id) {
        try {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Xóa sinh viên thành công",
                    studentService.deleteStudent(id),
                    HttpStatus.NO_CONTENT
            ), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    false,
                    e.getMessage(),
                    null,
                    HttpStatus.NOT_FOUND
            ), HttpStatus.NOT_FOUND);
        }
    }
}
