package com.spring.quizApp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.quizApp.entities.Question;
import com.spring.quizApp.service.QuestionService;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionservice;
    
  

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionservice.getAllQuestions();
    }


//    get questions by category
    @GetMapping("/{category}")
    public ResponseEntity<List<Question>> getAllByCategory(@PathVariable String category) {
       
            return  questionservice.getQuestionsByCategory(category);
        
    }



    @PostMapping("/addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionservice.addQuestion(question);

    }
    
   

}
