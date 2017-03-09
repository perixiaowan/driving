package com.xinhua.manage.exam.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xinhua.manage.system.user.model.TDrivingUser;

/**
 * TDrivingReport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_driving_report", catalog = "driving")
public class DrivingReport implements java.io.Serializable {

	// Fields

	private Integer id;
	private TDrivingUser user;
	private Integer examCatalog;
	private Integer userScore;
	private Date createTime;
	private Integer isDele;

	// Constructors

	/** default constructor */
	public DrivingReport() {
	}

	/** minimal constructor */
	public DrivingReport(TDrivingUser user, Integer examCatalog) {
		this.user = user;
		this.examCatalog = examCatalog;
	}

	/** full constructor */
	public DrivingReport(TDrivingUser TDrivingUser, Integer examCatalog,
			Integer userScore, Date createTime, Integer isDele) {
		this.user = TDrivingUser;
		this.examCatalog = examCatalog;
		this.userScore = userScore;
		this.createTime = createTime;
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

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user_id", nullable = false)
	public TDrivingUser getUser() {
		return user;
	}

	public void setUser(TDrivingUser user) {
		this.user = user;
	}
	
	@Column(name = "exam_catalog", nullable = false)
	public Integer getExamCatalog() {
		return this.examCatalog;
	}

	public void setExamCatalog(Integer examCatalog) {
		this.examCatalog = examCatalog;
	}

	@Column(name = "user_score")
	public Integer getUserScore() {
		return this.userScore;
	}

	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	@Column(name = "create_time", length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "is_dele")
	public Integer getIsDele() {
		return this.isDele;
	}

	public void setIsDele(Integer isDele) {
		this.isDele = isDele;
	}

}