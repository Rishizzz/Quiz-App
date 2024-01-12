package com.spring.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.quizApp.dao.QuestionDao;
import com.spring.quizApp.dao.QuizDao;
import com.spring.quizApp.entities.Question;
import com.spring.quizApp.entities.QuestionWrapper;
import com.spring.quizApp.entities.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;

    @Autowired
    QuestionDao questiondao;

    public String createQuiz(String category,  String title) {

        List<Question> questions=questiondao.findRandomQuestions(category);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);
        return "Questions Saved";
    }

    public List<QuestionWrapper> getQuiz(Integer id) {
        Optional<Quiz> quiz1=quizdao.findById(id);
//        here we use optional becoz if the ID enter is not present in a DB
//       QuestionWrapper wrapper=new QuestionWrapper();
     
        
       List<Question> questionFromDB=quiz1.get().getQuestions();
//     The get() method is used to extract the Quiz object from the Optional, and then 
//     the getQuestions() method is called on that Quiz object to retrieve the list of questions.
      
       List<QuestionWrapper> questionForUser=new ArrayList<>();  
       
       
       for(Question q: questionFromDB){
        QuestionWrapper wrapper1=new QuestionWrapper(q.getId(),q.getquestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
        questionForUser.add(wrapper1);
       }

       return questionForUser; 

    }
    
//    to calculate the score
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses1) {

        Optional<Quiz> quiz1=quizdao.findById(id);
        List<Question> questions=quiz1.get().getQuestions();
        
        int right = 0;
        int i = 0;
        
        for(Response response : responses1){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        } 
        
        System.out.println("correct Score is : "+ right);
        return new ResponseEntity<>(right, HttpStatus.OK);
    }


}
