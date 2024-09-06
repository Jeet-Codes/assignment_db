package com.softnerve.assignment.Service.ServiceImp;



import com.softnerve.assignment.Dto.StudentDto;
import com.softnerve.assignment.Model.Student;
import com.softnerve.assignment.Repository.StudentRepo;
import com.softnerve.assignment.Service.StudentMethods;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class StudentService implements StudentMethods {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        String s = "ST";
        String t = String.valueOf(new Date().getTime()).substring(10, 13);
        String studentid =s+ UUID.randomUUID().toString().toUpperCase().substring(0,4)+t;
        studentDto.setId(studentid);

        Student student = modelMapper.map(studentDto, Student.class);

        Student savedStudent = studentRepo.save(student);

        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(String id) {
        Student found = studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
        return modelMapper.map(found, StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(String id, StudentDto studentDto) {

        Student found = studentRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Student not found")
        );

        found.setName(studentDto.getName());
        found.setDetails(studentDto.getDetails());
        found.setPincode(studentDto.getPincode());
        found.setContact(studentDto.getContact());
        found.setAddress(studentDto.getAddress());

        Student saved = studentRepo.save(found);

        return modelMapper.map(saved, StudentDto.class);
    }

    @Override
    public String deleteStudent(String id) {
        studentRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Student not found")
        );
        studentRepo.deleteById(id);
        return "Student having id : " + id + " is deleted Successfully";
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> found = studentRepo.findAll();

        List<StudentDto> list = found.stream().map(x -> modelMapper.map(x, StudentDto.class)).toList();
        return list;
    }
}
