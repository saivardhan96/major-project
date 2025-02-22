package com.example.majorpro1.service;

import com.example.majorpro1.dto.PostDTO;
import com.example.majorpro1.entity.QuestionEntity;
import com.example.majorpro1.entity.UserEntity;
import com.example.majorpro1.repository.QuestionRepo;
import com.example.majorpro1.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;
    private final UserRepo userRepo;
    private List<QuestionEntity> allPosts = null;


    public QuestionService(QuestionRepo questionRepo, UserRepo userRepo) {
        this.questionRepo = questionRepo;
        this.userRepo = userRepo;
    }

    public List<QuestionEntity> getByCompany(String company){
        if(allPosts==null) return questionRepo.findAllByCompanyIgnoreCase(company);
        return allPosts.stream().filter( x -> Objects.equals(x.getCompany(),company)).toList();
    }

    public List<QuestionEntity> getByStage(String stage){
        if(allPosts==null)  return questionRepo.findAllByStageIgnoreCase(stage);
        return allPosts.stream().filter( x -> Objects.equals(x.getStage(),stage)).toList();
    }

    public List<QuestionEntity> getBySubject(String subject){
        if(allPosts==null) return questionRepo.findAllBySubjectIgnoreCase(subject);
        return allPosts.stream().filter( x -> Objects.equals(x.getSubject(),subject)).toList();
    }

    public List<QuestionEntity> getBySubAndStage(String subject, String stage){
        return questionRepo.findAllBySubjectAndStageIgnoreCase(subject,stage);
    }

    public List<QuestionEntity> getByTag(String tag){
        if(allPosts==null) return questionRepo.findAllByTagIgnoreCase(tag);
        return allPosts.stream().filter( x -> Objects.equals(x.getTag(),tag)).toList();
    }
    public void saveQuestion(QuestionEntity question, String username){
        Optional<UserEntity> entity =  userRepo.findById(username);
        UserEntity userInDb = entity.get();
        userInDb.getQuestions().add(questionRepo.save(question));
        userRepo.save(userInDb);
    }

    public List<PostDTO> getAllPosts(){
        return questionRepo.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
//        return allPosts;
    }

    private PostDTO convertEntityToDTO(QuestionEntity question){
        return new PostDTO(question.getCompany(), question.getSubject(), question.getQuestion());
    }


}
