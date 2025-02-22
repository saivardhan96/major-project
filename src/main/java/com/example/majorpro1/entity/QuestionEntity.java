package com.example.majorpro1.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "questions")
public class QuestionEntity {
    @Id
    private ObjectId id;
    private String company;
    private String stage;
    private String tag;
    private String subject;
    private String question;
}
