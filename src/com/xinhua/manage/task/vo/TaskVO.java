package com.xinhua.manage.task.vo;

import java.util.Date;

@SuppressWarnings("serial")
public class TaskVO implements java.io.Serializable {

	private Integer id;
	private String taskName;
	private String taskReferName;
	private Date startTime;
	private Date endTime;
	private Integer taskState;
	private Integer state;
	private String taskDecName;
	private Integer taskType;
	/**
	 * 结束时间毫秒数
	 */
	private Long endTimeMill;
	/**
	 * 当前时间毫秒数
	 */
	private Long nowTimeMill;

	/** default constructor */
	public TaskVO() {
	}

	public TaskVO(Integer id, String taskName,String taskReferName, Date startTime, Date endTime,
			Integer taskState, Integer state, String taskDecName) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.taskReferName = taskReferName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.taskState = taskState;
		this.state = state;
		this.taskDecName = taskDecName;
	}
	
	public TaskVO(Integer id, String taskName, Date endTime,Integer taskType) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.endTimeMill = endTime.getTime();
		this.nowTimeMill = new Date().getTime();
		this.taskType = taskType;
	}
	
	public TaskVO(Integer id, String taskReferName) {
		super();
		this.id = id;
		this.taskReferName = taskReferName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskReferName() {
		return taskReferName;
	}

	public void setTaskReferName(String taskReferName) {
		this.taskReferName = taskReferName;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getTaskState() {
		return this.taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTaskDecName() {
		return taskDecName;
	}

	public void setTaskDecName(String taskDecName) {
		this.taskDecName = taskDecName;
	}

	public Long getEndTimeMill() {
		return endTimeMill;
	}

	public void setEndTimeMill(Long endTimeMill) {
		this.endTimeMill = endTimeMill;
	}

	public Long getNowTimeMill() {
		return nowTimeMill;
	}

	public void setNowTimeMill(Long nowTimeMill) {
		this.nowTimeMill = nowTimeMill;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}
	
}