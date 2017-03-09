package com.xinhua.manage.exam.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.xinhua.log.model.Loggers;
import com.xinhua.manage.exam.model.ChoiceExam;
import com.xinhua.manage.exam.model.JudgeExam;
import com.xinhua.manage.system.user.model.TDrivingUser;
import com.xinhua.util.Util;
import com.xinhua.util.action.UtilBaseAction;

@ParentPackage("struts-default")
@Namespace("/exam")
@Action("exam")
@Results({
		@Result(name = "success", location = "/drivingschool/homepage/homepage.jsp"),
		@Result(name = "input", location = "/drivingschool/login.jsp"),
		@Result(name = "choice_list", location = "/drivingschool/exam/choice_list.jsp"),
		@Result(name = "choice_add",location = "/drivingschool/exam/choice_add.jsp"),
		@Result(name = "judge_add",location = "/drivingschool/exam/judge_add.jsp"),
		@Result(name = "choice_edit",location = "/drivingschool/exam/choice_edit.jsp"),
		@Result(name = "judge_edit",location = "/drivingschool/exam/judge_edit.jsp"),
		@Result(name = "choice_show",location = "/drivingschool/exam/choice_show.jsp"),	
		@Result(name = "judge_show",location = "/drivingschool/exam/judge_show.jsp"),	
		@Result(name = "error", location = "error.jsp")
})
@SuppressWarnings("all")

public class ExamAction extends UtilBaseAction {
	private List<ChoiceExam> choiceList1;
	private List<JudgeExam> judgeList1;
	private List<ChoiceExam> choiceList4;
	private List<JudgeExam> judgeList4;
	private ChoiceExam newChoiceExam;
	private JudgeExam newJudgeExam;
	private static final long serialVersionUID = 1L;

	
	public String choiceList() {
		try {
			
			/*int size = 10; // 单页记录条数
			int num = 1;// 当前页数
*/			int rowCount = 0;// 记录总数
			/*if(str_num != null && !"".equals(str_num)) {
				num = Integer.parseInt(str_num);
			}
			if (null != this.str_size && !"".equals(this.str_size)) {
				size = Integer.parseInt(this.str_size);
			}*/
			user = (TDrivingUser)this.contextPvd.getSessionAttr(Util.SECCION_CLIENT_USER);
			String orderStr = "d.createTime desc";//按ptime降序排列
			
			rowCount = (Integer) utilService.getCollection("ChoiceExam", null, orderStr, 0, 0,null);
/*			Page page = new Page(size,num,rowCount);
			this.setPage(page);*/
			choiceList1 = (List<ChoiceExam>) utilService.getHqlAll("from ChoiceExam c where  c.isDele = 0 order by c.createTime desc");
			judgeList1 = (List<JudgeExam>) utilService.getHqlAll("from JudgeExam j where j.isDele = 0 order by j.createTime desc");
			return "choice_list";
		} catch (Exception e) {
			Loggers.error("ExamAction类  choiceList方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;	
	}
	
	public String choiceAdd() {
		try {
			return "choice_add";
		} catch (Exception e) {
			Loggers.error("ExamAction类  choiceAdd方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	
	}
	public String judgeAdd() {
		try {
			return "judge_add";
		} catch (Exception e) {
			Loggers.error("ExamAction类  judgeAdd方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	
	}

	public String choiceSave() {
		try {
			newChoiceExam.setCreateTime(new Date());
			newChoiceExam.setUpdateTime(new Date());
			newChoiceExam.setExamRightNum(0);
			newChoiceExam.setExamWrongNum(0);
			newChoiceExam.setIsDele(0);
			utilService.save(newChoiceExam);
			Loggers.logToDB("执行了题目信息添加操作", contextPvd.getSessionId(Util.SECCION_CLIENT_USER), Util.CREATE);
			return this.choiceList();	
		} catch (Exception e) {
			Loggers.error("ExamAction类  choiceSave方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}

	public String judgeSave() {
		try {
			newJudgeExam.setCreateTime(new Date());
			newJudgeExam.setUpdateTime(new Date());
			newJudgeExam.setExamRightNum(0);
			newJudgeExam.setExamWrongNum(0);
			newJudgeExam.setIsDele(0);
			utilService.save(newJudgeExam);
			Loggers.logToDB("执行了判断题信息添加操作", contextPvd.getSessionId(Util.SECCION_CLIENT_USER), Util.CREATE);
			return this.choiceList();	
		} catch (Exception e) {
			Loggers.error("ExamAction类  judgeSave方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String  choiceEdit() {
		try {
			if (ids != null && !"".equals(ids)) {
				newChoiceExam = (ChoiceExam)utilService.getObjectById(ChoiceExam.class, Integer.parseInt(ids));	
			}
			Loggers.logToDB("执行了选择题信息修改操作", contextPvd.getSessionId(Util.SESSION_SYS_USER), Util.SHOW);
			return "choice_edit";
		} catch (Exception e) {
			Loggers.error("ExamAction类  choiceEdit方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String  judgeEdit() {
		try {
			if (ids != null && !"".equals(ids)) {
				newJudgeExam = (JudgeExam)utilService.getObjectById(JudgeExam.class, Integer.parseInt(ids));	
			}
			Loggers.logToDB("执行了选择题信息修改操作", contextPvd.getSessionId(Util.SESSION_SYS_USER), Util.SHOW);
			return "judge_edit";
		} catch (Exception e) {
			Loggers.error("ExamAction类  judgeEdit方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	
	public String choiceUpdate() {
		try {
			if (ids != null && !"".equals(ids)) {
				ChoiceExam oldchoiceExamInfo = (ChoiceExam)utilService.getObjectById(ChoiceExam.class, Integer.parseInt(ids));
				oldchoiceExamInfo.setExamTitle(newChoiceExam.getExamTitle());
				
				oldchoiceExamInfo.setExamCatalog(newChoiceExam.getExamCatalog());
				oldchoiceExamInfo.setExamOption1(newChoiceExam.getExamOption1());
				oldchoiceExamInfo.setExamOption2(newChoiceExam.getExamOption2());
				oldchoiceExamInfo.setExamOption3(newChoiceExam.getExamOption3());
				oldchoiceExamInfo.setExamOption4(newChoiceExam.getExamOption4());
				oldchoiceExamInfo.setExamAnswer(newChoiceExam.getExamAnswer());
				oldchoiceExamInfo.setUpdateTime(new Date());
				utilService.update(oldchoiceExamInfo);
			}
			Loggers.logToDB("执行了选择题信息更新操作", contextPvd.getSessionId(Util.SESSION_SYS_USER), Util.UPDATE);
			return this.choiceList();
		} catch (Exception e) {
			Loggers.error("ExamAction类  choiceUpdate方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	
	public String judgeUpdate() {
		try {
			if (ids != null && !"".equals(ids)) {
				JudgeExam oldjudgeExamInfo = (JudgeExam)utilService.getObjectById(JudgeExam.class, Integer.parseInt(ids));
				oldjudgeExamInfo.setExamTitle(newJudgeExam.getExamTitle());
				
				oldjudgeExamInfo.setExamCatalog(newJudgeExam.getExamCatalog());
				
				oldjudgeExamInfo.setExamAnswer(newJudgeExam.getExamAnswer());
				oldjudgeExamInfo.setUpdateTime(new Date());
				utilService.update(oldjudgeExamInfo);
			}
			Loggers.logToDB("执行了判断题信息更新操作", contextPvd.getSessionId(Util.SESSION_SYS_USER), Util.UPDATE);
			return this.choiceList();
		} catch (Exception e) {
			Loggers.error("ExamAction类  choiceUpdate方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	
	public String choiceDel() {
		try{
			if(null != ids && !"".equals(ids)){
				String hql = "update ChoiceExam u set u.isDele = 1 where u.id in ("+ids+")";
				utilService.deleteAll(hql);
			}
			return choiceList();
		}catch (Exception e) {
			Loggers.error("ExamAction类  choiceDel方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String judgeDel() {
		try{
			if(null != ids && !"".equals(ids)){
				String hql = "update JudgeExam j set j.isDele = 1 where j.id in ("+ids+")";
				utilService.deleteAll(hql);
			}
			return choiceList();
		}catch (Exception e) {
			Loggers.error("ExamAction类  judgeDel方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String choiceShow() {
		try {
			if(ids != null && !"".equals(ids)) {
				newChoiceExam = (ChoiceExam)utilService.getObjectById(ChoiceExam.class, Integer.parseInt(ids));
			}
			Loggers.logToDB("执行了试题信息查看操作", contextPvd.getSessionId(Util.SESSION_SYS_USER), Util.SHOW);
			return "choice_show";
		}  catch (Exception e) {
			Loggers.error("ExamAction类  choiceShow方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String judgeShow() {
		try {
			if(ids != null && !"".equals(ids)) {
				newJudgeExam = (JudgeExam)utilService.getObjectById(JudgeExam.class, Integer.parseInt(ids));
			}
			Loggers.logToDB("执行了选择题信息查看操作", contextPvd.getSessionId(Util.SESSION_SYS_USER), Util.SHOW);
			return "judge_show";
		}  catch (Exception e) {
			Loggers.error("ExamAction类  judgeShow方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public List<ChoiceExam> getChoiceList1() {
		return choiceList1;
	}



	public void setChoiceList1(List<ChoiceExam> choiceList1) {
		this.choiceList1 = choiceList1;
	}



	public List<JudgeExam> getJudgeList1() {
		return judgeList1;
	}



	public void setJudgeList1(List<JudgeExam> judgeList1) {
		this.judgeList1 = judgeList1;
	}



	public List<ChoiceExam> getChoiceList4() {
		return choiceList4;
	}



	public void setChoiceList4(List<ChoiceExam> choiceList4) {
		this.choiceList4 = choiceList4;
	}



	public List<JudgeExam> getJudgeList4() {
		return judgeList4;
	}



	public void setJudgeList4(List<JudgeExam> judgeList4) {
		this.judgeList4 = judgeList4;
	}

	public ChoiceExam getNewChoiceExam() {
		return newChoiceExam;
	}

	public void setNewChoiceExam(ChoiceExam newChoiceExam) {
		this.newChoiceExam = newChoiceExam;
	}

	public JudgeExam getNewJudgeExam() {
		return newJudgeExam;
	}

	public void setNewJudgeExam(JudgeExam newJudgeExam) {
		this.newJudgeExam = newJudgeExam;
	}




}
