package com.vijay.online_examination_system.DTO;

import java.sql.Date;

public class ExamDTO {
    private int id;
    private Long subjectId;
    private String desc;
    private Date date;
    private String marks;
    private String totalQuestion;
    private String passMarks;
    private String level;
    
	public int getId() {	
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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

