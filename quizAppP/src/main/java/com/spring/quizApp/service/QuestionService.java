package com.spring.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.quizApp.dao.QuestionDao;
import com.spring.quizApp.entities.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionDao dao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList(),HttpStatus.BAD_REQUEST);
    }
    
    
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(dao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    
    public ResponseEntity<String> addQuestion(Question question) {
        dao.save(question);
        System.out.println("Question Added successfully");
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

  
    
}
