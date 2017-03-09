package com.xinhua.manage.exam.action;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.xinhua.manage.exam.model.DrivingReport;
import com.xinhua.manage.system.user.model.TDrivingUser;
import com.xinhua.util.Loggers;
import com.xinhua.util.Util;
import com.xinhua.util.action.UtilBaseAction;

@ParentPackage("struts-default")
@Namespace("/report")
@Action("report")
@Results({
		@Result(name = "error", location = "error.jsp")
})
@SuppressWarnings("all")

public class ReportAction  extends UtilBaseAction{
	private Integer score;
	private String reporttimeString;
	private DrivingReport drivingReport = new DrivingReport();
	private List<DrivingReport> reportList = new ArrayList<DrivingReport>();
	private HttpServletResponse response;
	private PrintWriter out;
	
	public String reportSave() {
		try {
			user = (TDrivingUser)this.contextPvd.getSessionAttr(Util.SECCION_CLIENT_USER);
			drivingReport.setCreateTime(new Date());
			drivingReport.setUserScore(score);
			drivingReport.setIsDele(0);
			drivingReport.setExamCatalog(1);
			drivingReport.setUser(user);
			utilService.save(drivingReport);
			System.out.println("heihei");
			Loggers.logToDB("执行了用户科目一成绩添加操作", contextPvd.getSessionId(Util.SECCION_CLIENT_USER), Util.CREATE);
			return "none";
		} catch (Exception e) {
			Loggers.error("ReportAction类  reportSave方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String reportfourSave() {
		try {
			user = (TDrivingUser)this.contextPvd.getSessionAttr(Util.SECCION_CLIENT_USER);
			drivingReport.setCreateTime(new Date());
			drivingReport.setUserScore(score);
			drivingReport.setIsDele(0);
			drivingReport.setExamCatalog(4);
			drivingReport.setUser(user);
			utilService.save(drivingReport);
			System.out.println("heihei");
			Loggers.logToDB("执行了用户科目四成绩添加操作", contextPvd.getSessionId(Util.SECCION_CLIENT_USER), Util.CREATE);
			return "none";
		} catch (Exception e) {
			Loggers.error("ReportAction类  reportfourSave方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String reportShow() {
		try {
			//SimpleDateFormat time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			/*JSONArray jsontime = new JSONArray();
			JSONArray jsonscore = new JSONArray();*/
			JSONArray jsontmp = new JSONArray();
			JSONArray jsonone = new JSONArray();
			JSONArray jsonfour = new JSONArray();
			JSONArray jsondata = new JSONArray();
			user = (TDrivingUser)this.contextPvd.getSessionAttr(Util.SECCION_CLIENT_USER);
			String reportHql = "from DrivingReport d left join fetch d.user u where d.isDele=0 and u.id="+user.getId()+"order by d.createTime";
			reportList = (List<DrivingReport>) utilService.getHqlAll(reportHql);
			System.out.println("reportHql:"+reportHql);
			
			Date d = new Date();
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			
			for (DrivingReport item:reportList) {
				if(item.getExamCatalog()==1){
					d = item.getCreateTime();
					
					reporttimeString = format.format(d);
				/*	reporttimeString =time.format(item.getCreateTime());*/
					//System.out.println("reporttimeString:"+reporttimeString);
					jsontmp.add(reporttimeString);
					//System.out.println("reporttimeString:"+reporttimeString.getBytes());
					jsontmp.add(item.getUserScore());
					jsonone.add(jsontmp);
					jsontmp.clear();
				}else {
					d = item.getCreateTime();
					reporttimeString = format.format(d);
					jsontmp.add(reporttimeString);
					jsontmp.add(item.getUserScore());
					jsonfour.add(jsontmp);
					jsontmp.clear();
				}
				
			}
			
			jsondata.add(jsonone);
			jsondata.add(jsonfour);
			System.out.println("jsondata:"+jsondata);
			response = ServletActionContext.getResponse();
			response.setContentType("application/json;charset=UTF-8");
			out = response.getWriter();
			out.write(jsondata.toString());
			return "none";
		} catch (Exception e) {
			Loggers.error("ReportAction类  reportShow方法出错："+e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public DrivingReport getDrivingReport() {
		return drivingReport;
	}
	public void setDrivingReport(DrivingReport drivingReport) {
		this.drivingReport = drivingReport;
	}


	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}

	public List<DrivingReport> getReportList() {
		return reportList;
	}

	public void setReportList(List<DrivingReport> reportList) {
		this.reportList = reportList;
	}

	public String getReporttimeString() {
		return reporttimeString;
	}

	public void setReporttimeString(String reporttimeString) {
		this.reporttimeString = reporttimeString;
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
