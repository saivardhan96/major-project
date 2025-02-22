package com.example.majorpro1.repository;

import com.example.majorpro1.entity.QuestionEntity;
import com.example.majorpro1.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository <UserEntity,String> {

    public UserEntity findByCompany(String company);
    UserEntity findByUsername(String username);

    List<?> findAllByCompany(String company);

    List<UserEntity> findAllByUsername(String username);
}
