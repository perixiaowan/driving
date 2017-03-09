package com.xinhua.log.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Reslog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reslog")
@SuppressWarnings("all")
public class Reslog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String className;
	private String method;
	private String logLevel;
	private String message;
	private Date createTime;
	private Integer type;

	// Constructors

	/** default constructor */
	public Reslog() {
	}

	/** full constructor */
	public Reslog( String className, String method,
			String logLevel, String message, Date createTime, Integer type) {
		
		this.className = className;
		this.method = method;
		this.logLevel = logLevel;
		this.message = message;
		this.createTime = createTime;
		this.type = type;
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



	@Column(name = "class_name", length = 100)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "method", length = 100)
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "log_level", length = 50)
	public String getLogLevel() {
		return this.logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	@Column(name = "message", length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}