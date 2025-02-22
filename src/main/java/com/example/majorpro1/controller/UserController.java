package com.example.majorpro1.controller;


import com.example.majorpro1.entity.QuestionEntity;
import com.example.majorpro1.entity.UserEntity;
import com.example.majorpro1.repository.QuestionRepo;
import com.example.majorpro1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class UserController {

    /*// features
    * various query options
    * post questions
    * edit questions posted
    * get questions posted bt him
    *
    */
    private final UserService userService;
    private final QuestionRepo questionRepo;

    public UserController(UserService userService, QuestionRepo questionRepo) {
        this.userService = userService;
        this.questionRepo = questionRepo;
    }

    @GetMapping("/my-posts")
    public List<QuestionEntity> getPosts(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.getUserPosts(username);
    }

    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("UserName: " + username);
        try {
            return new ResponseEntity<>(userService.updateUser(user, username), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
