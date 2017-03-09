package com.xinhua.manage.exam.service.impl;



import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.xinhua.manage.exam.model.ChoiceExam;
import com.xinhua.manage.exam.model.JudgeExam;
import com.xinhua.manage.exam.service.BeginExamService;
import com.xinhua.util.service.UtilService;

@Service("beginExamService")
@SuppressWarnings("all")
public class BeginExamServiceImpl implements BeginExamService{
	
	protected UtilService utilService;
	private JSONArray jsonArrayChoice;
	private JSONArray jsonArrayJudge;
	private JSONArray jsonArray;
	private	JSONObject jsonObject;
	private ChoiceExam choiceExam;
	private JudgeExam judgeExam;
	private	List<ChoiceExam> choiceExamList;
	private List<JudgeExam> judgeExamList;
	
	
	private String choiceHql = "from ChoiceExam c where c.isDele=0 and c.examCatalog=";
	private String judgeHql = "from JudgeExam c where c.isDele=0 and c.examCatalog=";
	
	
	public   JSONArray getJsonAllArray(int catelogId) {
	
		
		try {
			
			choiceExamList =(ArrayList<ChoiceExam>)utilService.getHqlAll(choiceHql+catelogId);
			judgeExamList =  (ArrayList<JudgeExam>) utilService.getHqlAll(judgeHql+catelogId);
			jsonArray = changetoJsonArray(choiceExamList,judgeExamList);
			
			
			/*jsonArrayJudge = changetoJsonArray1(judgeExamList);
			
			System.out.println("choiceExamList.get(0):"+choiceExamList.get(0));
			System.out.println("choiceExamList.get(0).toString():"+choiceExamList.get(0).toString());
			jsonArrayJudge = jsonArrayJudge.fromObject(judgeExamList);*/
			
		//	System.out.println(jsonArrayChoice);
			System.out.println("-----------------------------");
			System.out.println(jsonArray);
			System.out.println("-----------------------------");
			//System.out.println(jsonArrayChoice);
	
			return jsonArray;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	private JSONArray changetoJsonArray(List<ChoiceExam> choiceList,List<JudgeExam> judgeExamList) {
		JSONArray jsonArrayAll = new JSONArray();
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArray1 = new JSONArray();
		JSONArray jsonArray2 = new JSONArray();
		/*HashMap<String, String> hashMap= new HashMap<String, String>();
		HashMap<String, HashMap> hashMapAll= new HashMap<String, HashMap>();*/
		String stringtmp = null;
		String title = null;
		String answer = null;
		String option1 = null;
		String option2 = null;
		String option3 = null;
		String option4 = null;
		String zhengque = "正确";
		String cuowu = "错误";
		String noString = "no";
		String yesString = "yes";
		String empty="";
		
		//ChoiceExam tmpJudge = null;
		for (ChoiceExam tmpChoice:choiceList) {
			title = tmpChoice.getExamTitle();
			answer = tmpChoice.getExamAnswer();
			option1 =tmpChoice.getExamOption1();
			option2 = tmpChoice.getExamOption2();
			option3 = tmpChoice.getExamOption3();
			option4 = tmpChoice.getExamOption4();
			if (answer.equals(option1)) {
				jsonArray2.add(option1);
				jsonArray2.add(yesString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option2);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				if (empty!=option3) {
					jsonArray2.add(option3);
					jsonArray2.add(noString);
					jsonArray1.add(jsonArray2);
					jsonArray2.clear();
				}
				
				if (empty!=option4) {
					jsonArray2.add(option4);
					jsonArray2.add(noString);
					jsonArray1.add(jsonArray2);
					jsonArray2.clear();
				}
			} else if(answer.equals(option2)){
				jsonArray2.add(option1);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option2);
				jsonArray2.add(yesString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				if (null!=option3&&""!=option3) {
					jsonArray2.add(option3);
					jsonArray2.add(noString);
					jsonArray1.add(jsonArray2);
					jsonArray2.clear();
				}
				
				if (!(empty==option4)) {
					jsonArray2.add(option4);
					jsonArray2.add(noString);
					jsonArray1.add(jsonArray2);
					jsonArray2.clear();
				}
			} else if (empty!=option3&&answer.equals(option3)) {
				jsonArray2.add(option1);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option2);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option3);
				jsonArray2.add(yesString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				
				if (!empty.equals(option4)) {
					jsonArray2.add(option4);
					jsonArray2.add(noString);
					jsonArray1.add(jsonArray2);
					jsonArray2.clear();
				}
			} else if (empty!=option4&&answer.equals(option4)) {
				jsonArray2.add(option1);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option2);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option3);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(option4);
				jsonArray2.add(yesString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
			}
			//System.out.println("JSONArray.fromObject(hashMap):"+JSONArray.fromObject(hashMap));
			jsonArray.add(title);
			jsonArray.add(jsonArray1);
			jsonArray1.clear();
			jsonArrayAll.add(jsonArray);
			jsonArray.clear();
		}
		for (JudgeExam tmpJudge:judgeExamList) {
			title = tmpJudge.getExamTitle();
			answer = tmpJudge.getExamAnswer();
			if (answer.equals(yesString)) {
				jsonArray2.add(zhengque);
				jsonArray2.add(yesString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(cuowu);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				
			} else {
				jsonArray2.add(cuowu);
				jsonArray2.add(noString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
				jsonArray2.add(zhengque);
				jsonArray2.add(yesString);
				jsonArray1.add(jsonArray2);
				jsonArray2.clear();
			} 
			
			jsonArray.add(title);
			jsonArray.add(jsonArray1);
			jsonArrayAll.add(jsonArray);
			jsonArray1.clear();
			jsonArray.clear();
		}
		
		System.out.println("jsonArrayAll:"+jsonArrayAll);
		return jsonArrayAll;
	}

	public UtilService getUtilService() {
		return utilService;
	}
	

	@Resource(name="utilService")
	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}
	
	public JSONArray getJsonArrayChoice() {
		return jsonArrayChoice;
	}

	public void setJsonArrayChoice(JSONArray jsonArrayChoice) {
		this.jsonArrayChoice = jsonArrayChoice;
	}

	public JSONArray getJsonArrayJudge() {
		return jsonArrayJudge;
	}

	public void setJsonArrayJudge(JSONArray jsonArrayJudge) {
		this.jsonArrayJudge = jsonArrayJudge;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public ChoiceExam getChoiceExam() {
		return choiceExam;
	}

	public void setChoiceExam(ChoiceExam choiceExam) {
		this.choiceExam = choiceExam;
	}

	public JudgeExam getJudgeExam() {
		return judgeExam;
	}

	public void setJudgeExam(JudgeExam judgeExam) {
		this.judgeExam = judgeExam;
	}

	public List<ChoiceExam> getChoiceExamList() {
		return choiceExamList;
	}

	public void setChoiceExamList(List<ChoiceExam> choiceExamList) {
		this.choiceExamList = choiceExamList;
	}

	public List<JudgeExam> getJudgeExamList() {
		return judgeExamList;
	}

	public void setJudgeExamList(List<JudgeExam> judgeExamList) {
		this.judgeExamList = judgeExamList;
	}

	public String getChoiceHql() {
		return choiceHql;
	}

	public void setChoiceHql(String choiceHql) {
		this.choiceHql = choiceHql;
	}

	public String getJudgeHql() {
		return judgeHql;
	}

	public void setJudgeHql(String judgeHql) {
		this.judgeHql = judgeHql;
	}

	
	
	
}
