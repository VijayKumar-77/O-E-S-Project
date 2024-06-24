package com.vijay.online_examination_system.DTO;

import java.sql.Date;

public class ResultDTO {
	private String status;
	private String score;
	private Date examDate;
	private String totalMarks;
	private String totalQuestion;
	private Long subjectId;
	private String userEmail;
	private Long examId;

	public ResultDTO(String status, String score, Date examDate, String totalMarks, String totalQuestion,
			Long subjectId, String userEmail, Long examId) {
		super();
		this.status = status;
		this.score = score;
		this.examDate = examDate;
		this.totalMarks = totalMarks;
		this.totalQuestion = totalQuestion;
		this.subjectId = subjectId;
		this.userEmail = userEmail;
		this.examId = examId;
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

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

}
