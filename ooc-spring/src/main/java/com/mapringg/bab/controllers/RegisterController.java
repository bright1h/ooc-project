package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Customer;
import com.mapringg.bab.models.RegisterForm;
import com.mapringg.bab.models.User;
import com.mapringg.bab.repositories.CustomerRepository;
import com.mapringg.bab.services.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public RegisterController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping
    public String registration(
            @RequestBody RegisterForm form
            ) {
        String fName = form.getfName();
        String lName = form.getlName();
        String phoneNo = form.getPhoneNo();
        String email = form.getEmail();
        String pwd = form.getPwd();
        String cPwd = form.getcPwd();
        String message;

        List<Customer> existedEmail =  customerService.getUsersByEmail(email);
        System.out.println(existedEmail.size());


        if (StringUtils.isBlank(fName)){
            message = "Please Enter First Name";
            return message;
        }
        else if(!StringUtils.isAlphanumeric(fName)){
            message = "First Name must not contain any special symbols.";
            return message;
        }
        else if (StringUtils.isBlank(lName)){
            message = "Please Enter Last Name";
            return message;
        }
        else if(!StringUtils.isAlphanumeric(lName)){
            message = "Last Name must not contain any special symbols.";
            return message;
        }
        else if (existedEmail.size() > 0){
            message = "This email is already existed";
            return message;
        }
        else if (StringUtils.isBlank(email)){
            message = "Please Enter Email";
            return message;
        }
        else if (StringUtils.isBlank(phoneNo)){
            message = "Please Enter Phone Number";
            return message;
        }
        else if (StringUtils.isBlank(pwd)){
            message = "Please Enter Password.";
            return message;
        }
        else if (!pwd.equals(cPwd)) {
            message = "Password and Confirmed Password are not match.";
            return message;
        }
        else {
            String hashedPwd = BCrypt.hashpw(pwd,BCrypt.gensalt());
            User newUser = new User(fName,lName,email,phoneNo,hashedPwd);
            customerRepository.save(newUser);
            message ="Register Successfully";
            System.out.println(message);
            return message;
        }

    }
    //Must Delete Later
    @GetMapping(path = "/getUsers")
    public Iterable<Customer> getUsers() {
        return customerService.getUsers();
    }

    @GetMapping(path = "/getGuests")
    public Iterable<Customer> getGuests() {
        return customerService.getGuests();
    }

    @GetMapping(path = "/getAdmins")
    public Iterable<Customer> getAdmins() {
        return customerService.getAdmins();
    }
}
