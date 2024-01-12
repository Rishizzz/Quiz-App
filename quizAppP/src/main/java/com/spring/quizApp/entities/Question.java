package com.spring.quizApp.entities;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String category;
    private String difficultylevel;
    
    public Question() {

    }
    public Question(Integer id, String questionTitle, String option1, String option2, String option3, String option4,
            String rightAnswer, String category, String difficultylevel) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.category = category;
        this.difficultylevel = difficultylevel;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setquestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }
    
    public Integer getId() {
        return id;
    }
    public String getquestionTitle() {
        return questionTitle;
    }
    public String getOption1() {
        return option1;
    }
    public String getOption2() {
        return option2;
    }
    public String getOption3() {
        return option3;
    }
    public String getOption4() {
        return option4;
    }
    public String getRightAnswer() {
        return rightAnswer;
    }
    public String getCategory() {
        return category;
    }
    public String getDifficultylevel() {
        return difficultylevel;
    }
	@Override
	public String toString() {
		return "Question [id=" + id + ", questionTitle=" + questionTitle + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", rightAnswer=" + rightAnswer
				+ ", category=" + category + ", difficultylevel=" + difficultylevel + "]";
	}
    

    
}
