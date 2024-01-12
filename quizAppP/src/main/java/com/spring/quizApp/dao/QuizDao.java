package com.spring.quizApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.quizApp.entities.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
