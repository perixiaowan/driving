package com.xinhua.manage.exam.action;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.ApplicationContext;

import com.xinhua.manage.exam.service.BeginExamService;
import com.xinhua.util.Loggers;
import com.xinhua.util.action.UtilBaseAction;

@ParentPackage("struts-default")
@Namespace("/beginexam")
@Action("beginexam")
@Results({
		/*@Result(name = "success", location = "/drivingschool/homepage/homepage.jsp"),
		@Result(name = "input", location = "/drivingschool/login.jsp"),*/
		@Result(name = "simulation_test", location = "/drivingschool/exam/simulation_test.jsp"),
		@Result(name = "simulation_test_four",location = "/drivingschool/exam/simulation_test_four.jsp"),
		@Result(name = "judge_add",location = "/drivingschool/exam/judge_add.jsp"),
		@Result(name = "choice_edit",location = "/drivingschool/exam/choice_edit.jsp"),
		@Result(name = "judge_edit",location = "/drivingschool/exam/judge_edit.jsp"),
		@Result(name = "choice_show",location = "/drivingschool/exam/choice_show.jsp"),	
		@Result(name = "judge_show",location = "/drivingschool/exam/judge_show.jsp"),	
		@Result(name = "error", location = "error.jsp")
})

@SuppressWarnings("all")
public class BeginAction extends UtilBaseAction {
	private JSONArray jsonArray;
	private BeginExamService beginExamService;
	private HttpServletResponse response;
	
	private PrintWriter out;
	
	/*private String choiceHql1 = "from ChoiceExam c where c.isDele=0 and c.examCatalog=1";
	private String judgeHql1 = "from JudgeExam c where c.isDele=0 and c.examCatalog=1";
	private String choiceHq4 = "from ChoiceExam c where c.isDele=0 and c.examCatalog=4";
	private String judgeHql4 = "from JudgeExam c where c.isDele=0 and c.examCatalog=4";*/
	
	public String beginExam() {
		try {
			
			return "simulation_test";
		} catch (Exception e) {
			Loggers.error("BeginAction类  beginExam方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;	
	}
	
	public String abtainJsonData() {
			
		try {
			jsonArray = beginExamService.getJsonAllArray(1);
		
			System.out.println("jsonArray"+jsonArray);
			response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
			out.write(jsonArray.toString());
			return "none";
		} catch (Exception e) {
			Loggers.error("BeginAction类  abtainJsonData方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;	
	}
	
	
	public String beginfourExam(){
		try{
			
		return "simulation_test_four";
	} catch (Exception e) {
		Loggers.error("BeginAction类  beginfourExam方法出错："+e.getMessage());
		e.printStackTrace();
	}
	
	return ERROR;	
}
	public String abtainFourJsonData(){
		try {
			jsonArray = beginExamService.getJsonAllArray(4);
		
			System.out.println("jsonArray"+jsonArray);
			response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
			out.write(jsonArray.toString());
			return "none";
		} catch (Exception e) {
			Loggers.error("BeginAction类  abtainJsonData方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;	
	}
	
	
	
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	public BeginExamService getBeginExamService() {
		return beginExamService;
	}
	
	@Resource(name="beginExamService")
	public void setBeginExamService(BeginExamService beginExamService) {
		this.beginExamService = beginExamService;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public PrintWriter getOut() {
		return out;
	}

	public void setOut(PrintWriter out) {
		this.out = out;
	}

}
