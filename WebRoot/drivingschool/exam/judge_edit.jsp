<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<base href="<%=basePath%>"/>

	<title>选择题目信息修改</title>
<style>
body { background: #ffffff; color: #444;font-size:12px; }
body, div, q, iframe, form, h5 { margin: 0; padding: 0; }
img, fieldset { border: none 0; }
body, td, textarea { word-break: break-all; word-wrap: break-word; line-height:1.6; }
body, input, textarea, select, button { margin: 0; font-size: 12px; font-family: Tahoma, SimSun, sans-serif; }
div, p, table, th, td { font-size:1em; font-family:inherit; line-height:inherit; }

</style>
<script type="text/javascript" src="<%=basePath%>js/zDrag.js"></script>
<script type="text/javascript" src="<%=basePath%>js/zDialog.js"></script>

</head>
<body>
	<div id="forlogin">
	<form action="<%=basePath%>exam/exam!judgeUpdate.action" name="myform" id="myFrm" method="post">
		<input type="hidden" name="ids" value="${ids}"/> 
		<table width="100%" border="0" align="center" cellpadding="4" cellspacing="4">
			<tbody>
				
				<tr>
	               	<td width="150" align="right">
	               		题目：
	               	</td>
	               	<td>
	               		<input type="text" id="newJudgeExam.examTitle" name="newJudgeExam.examTitle" class="input_normal" value="${newJudgeExam.examTitle }"/>
					    <img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
             	
             	<tr>
	               	<td width="150" align="right">
	               		科目类型：
	               	</td>
	               	<td>		                 			
	               		<s:if test="newJudgeExam.examCatalog==1">	
	                		<select id="newJudgeExam.examCatalog1" name="newJudgeExam.examCatalog" class="required">	
	                			<option value="1" selected="selected">科目一</option>
	                			<option value="4">科目四</option>
	                		</select>
	               		</s:if>
	               		<s:else>
	                		<select id="newJudgeExam.examCatalog4" name="newJudgeExam.examCatalog" class="required">
	                			<option value="1">科目一</option>
	                			<option value="4" selected="selected">科目四</option>
	                		</select>	
	               		</s:else>
	               	</td>
             	</tr>
             	
             	
             
             	<tr>
	               	<td width="150" align="right">
	               		试题答案：
	               	</td>
	               	<td>
		               	<input type="text" id="newJudgeExam.examAnswer" name="newJudgeExam.examAnswer" class="input_normal" value="${newJudgeExam.examAnswer}" />
						<img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
			</tbody>
		</table>
		<div align="center">
           	<table>
				<tr>
					<td>
				    	<input type="submit" class="button" value="保存"/>
                        <input type="reset" class="button" value="重置"/>
                           
				    </td>
				</tr>
			</table>
		</div>
	</form>
	</div>
</body>
</html>