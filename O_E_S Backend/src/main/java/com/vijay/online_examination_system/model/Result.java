package com.vijay.online_examination_system.model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Result {
 
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   @Column(name="result_status")
	   private String status;
	   
	   @Column(name="result_score")
	   private String score;
	   
	   @Column(name="exam_date")
	   private Date examDate;
	   
	   @Column(name="total_marks")
	   private String totalMarks;
	   
	   @Column(name="total_question")
	   private String totalQuestion;
	   
	   @ManyToOne
	   @JoinColumn(name= "subject_id")
	   private Subject sname;
	   
	   @Column(name= "user_email")
	   private String email;
	   
	   @ManyToOne
	   @JoinColumn(name= "exam_id", referencedColumnName = "id")
	   private Exam examId;
	   
	   public Result() {
	       // Default constructor
	   }

	   // Constructor with all fields except id
	   public Result(String status, String score, Date examDate, String totalMarks, String totalQuestion, Subject sname, String email, Exam examId) {
	       this.status = status;
	       this.score = score;
	       this.examDate = examDate;
	       this.totalMarks = totalMarks;
	       this.totalQuestion = totalQuestion;
	       this.sname = sname;
	       this.email = email;
	       this.examId = examId;
	   }

	   
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(String totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public Subject getSname() {
		return sname;
	}

	public void setSname(Subject sname) {
		this.sname = sname;
	}

	public Exam getExamId() {
		return examId;
	}

	public void setExamId(Exam examId) {
		this.examId = examId;
	}   
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Result result = (Result) o;
    return Objects.equals(id, result.id);
}

@Override
public int hashCode() {
    return Objects.hash(id);
}

@Override
public String toString() {
    return "Result{" +
            "id=" + id +
            ", status='" + status + '\'' +
            ", score='" + score + '\'' +
            ", examDate=" + examDate +
            ", totalMarks='" + totalMarks + '\'' +
            ", totalQuestion='" + totalQuestion + '\'' +
            ", sname=" + sname +
            ", email='" + email + '\'' +
            ", examId=" + examId +
            '}';
}
}