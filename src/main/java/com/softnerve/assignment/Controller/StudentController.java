package com.softnerve.assignment.Controller;

import com.softnerve.assignment.Dto.StudentDto;
import com.softnerve.assignment.Service.ServiceImp.StudentService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student){
        StudentDto saved = studentService.createStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @Operation(tags = "Get  All Student Details ",
            description = "Student details"
    )
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Operation(tags = "Get Student Details ",
                description = "Student details by ID"
                )


    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id){
        StudentDto student = studentService.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }


    @Hidden  // This to hide in Swagger Documentation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        String deleted = studentService.deleteStudent(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id,@RequestBody StudentDto student){
        StudentDto updated = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }
}
