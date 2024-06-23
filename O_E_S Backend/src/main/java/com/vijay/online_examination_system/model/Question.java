package com.vijay.online_examination_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  
	  @Column(name="question_name")
	  private String question_name;
	  private String option_one;
	  private String option_two;
	  private String option_three;
	  private String option_four;
	  
	  @Column(name="question_answer")
	  private String answer;
	  
	   @ManyToOne
	   private Subject sname_subject_name;
	   
	   @ManyToOne
	   private Exam ename;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_name() {
		return question_name;
	}

	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}

	public String getOption_one() {
		return option_one;
	}

	public void setOption_one(String option_one) {
		this.option_one = option_one;
	}

	public String getOption_two() {
		return option_two;
	}

	public void setOption_two(String option_two) {
		this.option_two = option_two;
	}

	public String getOption_three() {
		return option_three;
	}

	public void setOption_three(String option_three) {
		this.option_three = option_three;
	}

	public String getOption_four() {
		return option_four;
	}

	public void setOption_four(String option_four) {
		this.option_four = option_four;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Subject getSname_subject_name() {
		return sname_subject_name;
	}

	public void setSname_subject_name(Subject sname_subject_name) {
		this.sname_subject_name = sname_subject_name;
	}

	public Exam getEname() {
		return ename;
	}

	public void setEname(Exam ename) {
		this.ename = ename;
	}

}