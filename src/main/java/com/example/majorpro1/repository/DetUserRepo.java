package com.example.majorpro1.repository;

import com.example.majorpro1.entity.DetUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DetUserRepo extends MongoRepository<DetUser, String> {
    boolean existsByUsername(String username);
}
