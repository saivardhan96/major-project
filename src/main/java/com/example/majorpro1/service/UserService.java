package com.example.majorpro1.service;


import com.example.majorpro1.entity.DetUser;
import com.example.majorpro1.entity.QuestionEntity;
import com.example.majorpro1.entity.UserEntity;
import com.example.majorpro1.repository.DetUserRepo;
import com.example.majorpro1.repository.QuestionRepo;
import com.example.majorpro1.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final DetUserRepo detUserRepo;
    private final QuestionRepo questionRepo;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepo userRepo, DetUserRepo detUserRepo, QuestionRepo questionRepo) {
        this.userRepo = userRepo;
        this.detUserRepo = detUserRepo;
        this.questionRepo = questionRepo;
    }

    public UserEntity saveUser(UserEntity user) {
        if(userRepo.existsById(user.getUsername())) throw new KeyAlreadyExistsException("Username is unavailable");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public DetUser saveDetUser(DetUser detUser){
        if(detUserRepo.existsByUsername(detUser.getUsername())) throw new KeyAlreadyExistsException("Username is unavailable");
        detUser.setPassword(passwordEncoder.encode(detUser.getPassword()));
        return detUserRepo.save(detUser);
    }

    public UserEntity updateUser(UserEntity user,String username) throws Exception {
        UserEntity userInDb = userRepo.findByUsername(username);
        userInDb.setPassword(user.getPassword());
        userInDb.setUsername(user.getUsername());
        try{
            return saveUser(userInDb);
        } catch (Exception e){
            throw new Exception(e);
        }
    }
    public List<QuestionEntity> getUserPosts(String username){
       return userRepo.findByUsername(username).getQuestions();
    }

}
