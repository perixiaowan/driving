<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<title>选择题信息查看</title>
<style>
body { background: #ffffff; color: #444;font-size:12px; }
a { color: #07c; text-decoration: none; border: 0; background-color: transparent; }
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
		<table width="100%" border="0" align="center" cellpadding="4" cellspacing="4" bordercolor="#666666">
			<tbody>
				<tr>
	               	<td width="150" align="right">
	               		题目：
	               	</td>
	               	<td>
	               		<label id="qq">${newChoiceExam.examTitle}</label>
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		科目类型：
	               	</td>
	               	<td>
	               		<s:if test="#newChoiceExam.examCatalog==1">
	               			<label id="qq">科目一</label>
	               			
	               		</s:if>
	               		<s:else>
	               			<label id="qq">科目四</label>	
	               		</s:else>
	               	</td>
	            </tr>
             	<tr>
	               	<td width="150" align="right">
	               		选项一：
	               	</td>
	               	<td>
	               		<label id="qq">${newChoiceExam.examOption1}</label>
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		选项二：
	               	</td>
	               	<td>
	               		<label id="qq">${newChoiceExam.examOption2}</label>
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		选项三：
	               	</td>
	               	<td>
	               		<label id="qq">${newChoiceExam.examOption3}</label>
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		选项四：
	               	</td>
	               	<td>
	               		<label id="qq">${newChoiceExam.examOption4}</label>
	               	</td>
             	</tr>
             	<tr>
	               	<td width="150" align="right">
	               		试题答案：
	               	</td>
	               	<td>
	               		<label id="qq">${newChoiceExam.examAnswer}</label>
	               	</td>
             	</tr>
             
             	<tr>
				    <td width="150" align="right">
				    	创建时间：
				    </td>
				    <td>
		            	<fmt:formatDate value="${newChoiceExam.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				    </td>
				</tr> 
				<tr>
				    <td width="150" align="right">
				    	更新时间：
				    </td>
				    <td>
		            	<fmt:formatDate value="${newChoiceExam.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				    </td>
				</tr>
			
			</tbody>
		</table>
		
	</div>
</body>
</html>