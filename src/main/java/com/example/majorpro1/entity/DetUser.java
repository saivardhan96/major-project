package com.example.majorpro1.entity;


import com.mongodb.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "TrailUsers")
public class DetUser {

    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private int batch;
    private String branch;
    private String email;
    private String phoneNumber;
    @DBRef
    private List<DetPost> posts = new ArrayList<>();

}
