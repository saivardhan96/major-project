package com.example.majorpro1.controller;


import com.example.majorpro1.entity.DetUser;
import com.example.majorpro1.entity.UserEntity;
import com.example.majorpro1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicController {
    private final UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = { "/register-user"})
    public String indexPage(){
        return "userRegistration";
    }

    @PostMapping("/register-user")
    public String saveUser(@ModelAttribute UserEntity user){
        // register new user
        System.out.println("saving user..." + user.getUsername());
        return "postForm";
    }

    @GetMapping(value = { "/login"})
    public String login(){
        return "login";
    }

    @GetMapping(value = { "/home"})
    public String home(){
        return "index";
    }




    @PostMapping("/new-detUser")
    public ResponseEntity<DetUser> newDetUser(@RequestBody DetUser detUser){
        try{
            return new ResponseEntity<>(userService.saveDetUser(detUser) , HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
