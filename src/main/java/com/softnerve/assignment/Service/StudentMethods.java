package com.softnerve.assignment.Service;

import com.softnerve.assignment.Dto.StudentDto;
import com.softnerve.assignment.Model.Student;

import java.util.List;

public interface StudentMethods {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(String id);
    StudentDto updateStudent(String id,StudentDto studentDto);
    String deleteStudent(String id);
    List<StudentDto> getStudents();
}
