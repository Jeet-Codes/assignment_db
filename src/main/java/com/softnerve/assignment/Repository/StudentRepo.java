package com.softnerve.assignment.Repository;

import com.softnerve.assignment.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepo extends MongoRepository<Student, String> {



}
