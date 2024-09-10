package com.softnerve.assignment.Repository;

import com.softnerve.assignment.Model.Users;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthuserRepo extends MongoRepository<Users,Integer> {

}
