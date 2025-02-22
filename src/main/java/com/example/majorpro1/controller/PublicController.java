package com.example.majorpro1.controller;


import com.example.majorpro1.entity.UserEntity;
import com.example.majorpro1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    private final UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        // register new user
        try{
            return new ResponseEntity<>(userService.saveUser(user) , HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("companies")
    public void getCompanies(){
        // return all available companies

    }



}
