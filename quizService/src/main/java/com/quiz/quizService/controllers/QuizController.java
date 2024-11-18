package com.quiz.quizService.controllers;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.repository.QuestionClient;
import com.quiz.quizService.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private QuestionClient questionClient;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }
    @GetMapping
    public List<Quiz> allquiz(){
        return quizService.getAllQuizes();
    }
    @GetMapping("/{id}")
    public Quiz quiz(@PathVariable Long id){
        return quizService.getQuiz(id);
    }

}
