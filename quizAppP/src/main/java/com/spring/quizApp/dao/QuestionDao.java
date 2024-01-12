package com.spring.quizApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.quizApp.entities.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
	
   public List<Question> findByCategory(String category);

   @Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() ",nativeQuery=true)
   public List<Question> findRandomQuestions(String category);
    
   
  /* 1."SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM()": This is 
    the SQL query you are executing. It selects all records from the "question" table 
    where the "category" column matches the value provided by the :category parameter.
     The ORDER BY RANDOM() part is used to randomize the order of the results.

     2. nativeQuery=true: This part specifies that the query is a native SQL query, which 
     means you are writing the SQL query directly.  */
}
