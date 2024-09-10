package com.softnerve.assignment.Controller;


//import com.softnerve.assignment.Service.ServiceImp.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {



    @GetMapping("/")
    public String greet(){

        return "Hello SoftNer v1.0";
    }
}
