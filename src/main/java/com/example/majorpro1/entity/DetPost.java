package com.example.majorpro1.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@NoArgsConstructor
@Document(collection = "TrailPosts")
public class DetPost {

    @Id
    private String id;
    private HashMap<String, String> questions;
    private String suggestions;
    private HashMap<String, String> resources;
    private String difficultyLevel;
    private String oaResult;
    private String inResult;

}
