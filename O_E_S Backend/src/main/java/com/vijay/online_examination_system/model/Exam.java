//package com.vijay.online_examination_system.model;
//
//import java.sql.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//
//@Entity
//public class Exam {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@ManyToOne
//	private Subject subject;
//
//	@Column(name = "exam_desc")
//	private String desc;
//
//	@Column(name = "exam_date")
//	@Temporal(TemporalType.DATE)
//	private Date date;
//
//	@Column(name = "exam_marks")
//	private String marks;
//
//	@Column(name = "exam_totalQuestion")
//	private String totalQuestion;
//
//	@Column(name = "exam_passMarks")
//	private String passMarks;
//
//	@Column(name = "exam_level")
//	private String level;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Subject getSubject() {
//		return subject;
//	}
//
//	public void set(Subject subject) {
//		this.subject = subject;
//	}
//
//	public String getDesc() {
//		return desc;
//	}
//
//	public void setDesc(String desc) {
//		this.desc = desc;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getMarks() {
//		return marks;
//	}
//
//	public void setMarks(String marks) {
//		this.marks = marks;
//	}
//
//	public String getTotalQuestion() {
//		return totalQuestion;
//	}
//
//	public void setTotalQuestion(String totalQuestion) {
//		this.totalQuestion = totalQuestion;
//	}
//
//	public String getPassMarks() {
//		return passMarks;
//	}
//
//	public void setPassMarks(String passMarks) {
//		this.passMarks = passMarks;
//	}
//
//	public String getLevel() {
//		return level;
//	}
//
//	public void setLevel(String level) {
//		this.level = level;
//	}
//}

package com.vijay.online_examination_system.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "exam_desc")
    private String desc;

    @Column(name = "exam_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "exam_marks")
    private String marks;

    @Column(name = "exam_totalQuestion")
    private String totalQuestion;

    @Column(name = "exam_passMarks")
    private String passMarks;

    @Column(name = "exam_level")
    private String level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(String totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public String getPassMarks() {
		return passMarks;
	}

	public void setPassMarks(String passMarks) {
		this.passMarks = passMarks;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

  
}
