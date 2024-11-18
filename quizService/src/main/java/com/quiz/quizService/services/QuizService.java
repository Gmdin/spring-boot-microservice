package com.quiz.quizService.services;

import com.quiz.quizService.entity.Quiz;
import com.quiz.quizService.repository.QuestionClient;
import com.quiz.quizService.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    public Quiz addQuiz(Quiz quiz){
        return quizRepository.save(quiz);
    }
    public List<Quiz> getAllQuizes(){

        List<Quiz> quizzes=quizRepository.findAll();
        List<Quiz> quizList=quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return quizList;
    }
    public Quiz getQuiz(Long id){
            Quiz quiz=quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
    }
}
