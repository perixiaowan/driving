package com.xinhua.manage.task.service;

import com.xinhua.manage.task.model.Task;

@SuppressWarnings("all")
public interface TaskService{
	
	/**
	 * 申报任务处理方法
	 * @throws Exception
	 */
	public abstract void taskSet(Task task,String taskSetState) throws Exception;
}

