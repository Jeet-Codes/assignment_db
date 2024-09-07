package com.softnerve.assignment.Controller;

import com.softnerve.assignment.Dto.StudentDto;
import com.softnerve.assignment.Service.ServiceImp.StudentService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(tags = "Create Student",
            description = "Create a new student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student){
        StudentDto saved = studentService.createStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @Operation(tags = "Get All Students",
            description = "Retrieve all student details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of students retrieved successfully")
    })

    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }



    @Operation(tags = "Get Student by ID",
            description = "Retrieve a student's details by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student details retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable String id){
        StudentDto student = studentService.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }


    @Operation(tags = "Delete Student",
            description = "Delete a student by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
//    @Hidden  // This to hide in Swagger Documentation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        String deleted = studentService.deleteStudent(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }


    @Operation(tags = "Update Student Details",
            description = "Update an existing student's details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student details updated successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id,@RequestBody StudentDto student){
        StudentDto updated = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updated, HttpStatus.OK);

    }
}
