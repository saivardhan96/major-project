package com.example.majorpro1.repository;

import com.example.majorpro1.entity.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepo extends MongoRepository<QuestionEntity,String> {

    List<QuestionEntity> findAllByCompanyIgnoreCase(String company);
    List<QuestionEntity> findAllByStageIgnoreCase(String stage);
    List<QuestionEntity> findAllByTagIgnoreCase(String company);
    List<QuestionEntity> findAllBySubjectIgnoreCase(String subject);
    List<QuestionEntity> findAllBySubjectAndStageIgnoreCase(String subject, String stage);

//    List<QuestionEntity> findAllBy


}
