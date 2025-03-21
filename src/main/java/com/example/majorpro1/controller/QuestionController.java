package com.example.majorpro1.controller;


import com.example.majorpro1.dto.PostDTO;
import com.example.majorpro1.entity.QuestionEntity;
import com.example.majorpro1.service.QuestionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @PostMapping("/new-post/save")
    public void postQuestion(@RequestBody QuestionEntity question){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("username" + username);
        questionService.saveQuestion(question,username);
    }

    @GetMapping("/new-post")
    public String newPostForm(Model model){

        return "postForm";
    }

    @GetMapping("/show")
    public List<PostDTO> postsByCondition(@RequestParam(required = false) String Company,
                                          @RequestParam(required = false) String Tag,
                                          @RequestParam(required = false) String Stage,
                                          @RequestParam(required = false) String Subject){
/*
        if(Company!=null) return questionService.getByCompany(Company.toLowerCase());
        if(Tag!=null) return questionService.getByTag(Tag.toLowerCase());
        if(Stage!=null) return questionService.getByStage(Stage.toLowerCase());
        if(Subject!=null) return questionService.getBySubject(Subject.toLowerCase());*/
        return questionService.getAllPosts();

    }

/*
    @GetMapping("/")
    public List<QuestionEntity> questionsByTag(@RequestParam String tag){
        return questionService.getByTag(tag);
    }
    @GetMapping("/")
    public List<QuestionEntity> questionsByStage(@RequestParam String stage){
        return questionService.getByStage(stage);
    }
    @GetMapping("/")
    public List<QuestionEntity> questionsBySubject(@RequestParam String subject){
        return questionService.getBySubject(subject);
    }

    @GetMapping("/")
    public List<QuestionEntity> questionsBySubandStage(@RequestParam String subject, @RequestParam String stage){
        return questionService.getBySubAndStage(subject,stage);
    }*/
}
