package com.question.questionService.service;

import com.question.questionService.entity.Question;
import com.question.questionService.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }
    public Question getById(Long id){
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    public List<Question> getQuectionByQuiz(Long quizId){
        return questionRepository.findByQuizId(quizId);
    }
}
