package com.xinhua.manage.exam.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TDrivingJudgeExam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_driving_judge_exam", catalog = "driving")
public class JudgeExam implements java.io.Serializable {

	// Fields

	private Integer id;
	private String examTitle;
	private Integer examCatalog;
	private Integer examRightNum;
	private Integer examWrongNum;
	private String examAnswer;
	private Date createTime;
	private Date updateTime;
	private Integer isDele;

	// Constructors

	/** default constructor */
	public JudgeExam() {
	}

	/** minimal constructor */
	public JudgeExam(String examTitle) {
		this.examTitle = examTitle;
	}

	/** full constructor */
	public JudgeExam(String examTitle, Integer examCatalog,
			Integer examRightNum, Integer examWrongNum, String examAnswer,
			Date createTime, Date updateTime, Integer isDele) {
		this.examTitle = examTitle;
		this.examCatalog = examCatalog;
		this.examRightNum = examRightNum;
		this.examWrongNum = examWrongNum;
		this.examAnswer = examAnswer;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDele = isDele;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "exam_title", nullable = false)
	public String getExamTitle() {
		return this.examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	@Column(name = "exam_catalog")
	public Integer getExamCatalog() {
		return this.examCatalog;
	}

	public void setExamCatalog(Integer examCatalog) {
		this.examCatalog = examCatalog;
	}

	@Column(name = "exam_right_num")
	public Integer getExamRightNum() {
		return this.examRightNum;
	}

	public void setExamRightNum(Integer examRightNum) {
		this.examRightNum = examRightNum;
	}

	@Column(name = "exam_wrong_num")
	public Integer getExamWrongNum() {
		return this.examWrongNum;
	}

	public void setExamWrongNum(Integer examWrongNum) {
		this.examWrongNum = examWrongNum;
	}

	@Column(name = "exam_answer", length = 10)
	public String getExamAnswer() {
		return this.examAnswer;
	}

	public void setExamAnswer(String examAnswer) {
		this.examAnswer = examAnswer;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 0)
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "is_dele")
	public Integer getIsDele() {
		return this.isDele;
	}

	public void setIsDele(Integer isDele) {
		this.isDele = isDele;
	}

}