package com.spring.quizApp.controller;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.quizApp.entities.QuestionWrapper;
import com.spring.quizApp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController{

    @Autowired
    QuizService quizService;

    
//    use this Url localhost:8090/quiz/create?category=Java&title=JQ
    @PostMapping("/create")
    public String createQuiz(@RequestParam String category ,@RequestParam String title){
        return quizService.createQuiz(category,title);
    }

    @GetMapping("/id/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }
    
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}