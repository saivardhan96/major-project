package com.example.majorpro1.entity;


import com.mongodb.lang.NonNull;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class UserEntity {
    @Id
    private String username;
    private String password;
    private String company;
    @DBRef
    private List<QuestionEntity> questions = new ArrayList<>();

    // maybe we can add his details
}
