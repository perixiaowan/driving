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

	<title>题目信息修改</title>
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
	<form action="<%=basePath%>exam/exam!choiceUpdate.action" name="myform" id="myFrm" method="post">
		<input type="hidden" name="ids" value="${ids}"/> 
		<table width="100%" border="0" align="center" cellpadding="4" cellspacing="4">
			<tbody>
				
				<tr>
	               	<td width="150" align="right">
	               		题目：
	               	</td>
	               	<td>
	               		<input type="text" id="examTitle" name="newChoiceExam.examTitle" class="input_normal" value="${newChoiceExam.examTitle }"/>
					    <img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
             	
             	<tr>
	               	<td width="150" align="right">
	               		科目类型：
	               	</td>
	               	<td>		                 			
	               		<s:if test="newChoiceExam.examCatalog==1">	
	                		<select id="examCatalog" name="newTitle.examCatalog" class="required">	
	                			<option value="1" selected="selected">科目一</option>
	                			<option value="4">科目四</option>
	                		</select>
	               		</s:if>
	               		<s:else>
	                		<select id="examCatalog" name="newTitle.examCatalog" class="required">
	                			<option value="1">科目一</option>
	                			<option value="4" selected="selected">科目四</option>
	                		</select>	
	               		</s:else>
	               	</td>
             	</tr>
             	
             	
             	
             	<tr>
	               	<td width="150" align="right">
	               		选项一：
	               	</td>
	               	<td>
	               		<input type="text" id="examOption1" name="newChoiceExam.examOption1" class="input_normal" value="${newChoiceExam.examOption1}" />
						<img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		选项二：
	               	</td>
	               	<td>
	               		<input type="text" id="examOption2" name="newChoiceExam.examOption2" class="input_normal" value="${newChoiceExam.examOption2}" />
						<img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
             	
             	<tr>
	               	<td width="150" align="right">
	               		选项三：
	               	</td>
	               	<td>
	               		<input type="text" id="examOption3" name="newChoiceExam.examOption3" class="input_normal" value="${newChoiceExam.examOption3}" />
						<img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		选项四：
	               	</td>
	               	<td>
	               		<input type="text" id="examOption4" name="newChoiceExam.examOption4" class="input_normal" value="${newChoiceExam.examOption4}" />
						<img src="<%=basePath%>images/title/xinghao_03.jpg" />
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		试题答案：
	               	</td>
	               	<td>
		               	<input type="text" id="examAnswer" name="newChoiceExam.examAnswer" class="input_normal" value="${newChoiceExam.examAnswer}" />
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