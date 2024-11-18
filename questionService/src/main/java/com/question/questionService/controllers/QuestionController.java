package com.question.questionService.controllers;

import com.question.questionService.entity.Question;
import com.question.questionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getData(@PathVariable Long id){
        return questionService.getById(id);
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @GetMapping("quiz/{id}")
    public List<Question> getAllQuestionOfaQuiz(@PathVariable Long id){
        return  questionService.getQuectionByQuiz(id);
    }

}
