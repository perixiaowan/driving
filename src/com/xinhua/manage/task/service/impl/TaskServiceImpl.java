package com.xinhua.manage.task.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xinhua.manage.task.model.Task;
import com.xinhua.manage.task.service.TaskService;
import com.xinhua.util.dao.UtilDao;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	@Resource(name = "utilDao")
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public void taskSet(Task task, String taskSetState) throws Exception {
		if(taskSetState != null && !"".equals(taskSetState)){
			task.setState(Integer.parseInt(taskSetState));
			if(taskSetState != null && taskSetState.equals("1")){
				task.setTaskState(2);
			} else if(taskSetState != null && taskSetState.equals("0")){
				Date now = new Date();
				if (now.before(task.getStartTime())){
					task.setTaskState(0);
				} else if (now.after(task.getEndTime())){
					task.setTaskState(2);
				} else {
					task.setTaskState(1);
				}
			}
			utilDao.update(task);
			String hql = "update BaseMain set historyState="+taskSetState+" where isDele = 0 and fkTask.id = "+task.getId() +" and taskFlag = "+task.getTaskFlag();
			utilDao.updateAll(hql);
		}
	}
}
