package com.xinhua.manage.task.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_task")
public class Task implements java.io.Serializable {

	private Integer id;
	private String taskName;
	private String taskReferName;
	private Date startTime;
	private Date endTime;
	private Integer taskState;
	private String taskFlag;
	private Integer taskType;
	private Integer state;
	private Date createTime;
	private Date updateTime;
	private Integer isDele;

	/** default constructor */
	public Task() {
	}

	/** full constructor */
	public Task(String taskName, Date startTime, Date endTime,
			Integer taskState, String taskFlag, Integer taskType,
			Integer state, Date createTime, Date updateTime, Integer isDele) {
		this.taskName = taskName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.taskState = taskState;
		this.taskFlag = taskFlag;
		this.taskType = taskType;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isDele = isDele;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "task_name")
	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name="task_refer_name")
	public String getTaskReferName() {
		return taskReferName;
	}

	public void setTaskReferName(String taskReferName) {
		this.taskReferName = taskReferName;
	}

	@Column(name = "start_time", length = 19)
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "task_state")
	public Integer getTaskState() {
		return this.taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	@Column(name = "task_flag")
	public String getTaskFlag() {
		return this.taskFlag;
	}

	public void setTaskFlag(String taskFlag) {
		this.taskFlag = taskFlag;
	}

	@Column(name = "task_type")
	public Integer getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
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