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
    <title>考试题目添加</title>
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>plug-in-js/jquery-validate/css/jquery-validation/validate.css"/>
    
    <script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
    <script src="<%=basePath%>plug-in-js/jquery-validate/js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>plug-in-js/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
    <script src="<%=basePath%>plug-in-js/jquery-validate/js/messages_cn.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/plug-in-js/lhgdialog4.2.0/lhgdialog.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>js/table_show.js"  type="text/javascript" ></script>
    <script type="text/javascript">
	    $(document).ready(function() {
	    	$("#myFrm").validate({
	    		submitHandler: function() { 
	    			form.submit();
	    		},
	    		rules: {
	    			"newJudgeExam.examTitle": {
	    				required: true,
	    				minlength: 2,
	    				maxlength: 100
	    			},
	    			"newJudgeExam.examAnswer": {
	    				required: true,
	    				minlength: 3,
	    				maxlength: 3
	    			}
	    		}
	    	});
	    });
	    
	   
    </script>
  </head>
  <body>
  	<div class="right">
		<div class="right_box">
        	
	       	<div class="right_table">
	       	<form action="<%=basePath%>exam/exam!judgeSave.action" name="myform" id="myFrm" method="post">
	       	
	       		
	       		<s:token />
	            	
	            	
	            	<div class="right_table_list">
	                	<table border="0" cellpadding="0" cellspacing="0" class="table_info">
	                    	<tr>
	                        	<th>
		                             <div class="table_info_tit">
		                             	<img src="<%=basePath%>images/icon_02.gif"/>添加题目信息(如无此信息，则填“<font color="red">无</font>”)
		                             </div>
		                            
	                        	</th>
	                      	</tr>
	                      	<tr>
	                        	<td id="table_show" style="display: block;width:100%">
						          	<table border="0" cellpadding="0" cellspacing="0" class="table_addlist">
						               	
						               	
						               		<tr>
							                 	<td width="20%" class="table_rleft">
							                 		题目：
							                 	</td>
							                 	<td width="80%">
							                 		<textarea id="newJudgeExam.examTitle" name="newJudgeExam.examTitle" rows="2" cols="50"></textarea>
							                 		<img src="<%=basePath%>images/title/xinghao_03.jpg" />
					                         		
							                 	</td>
							               	</tr>
							               		<tr>
							                 	<td class="table_rleft">
							                 		科目类型：
							                 	</td>
							                 	<td>
							                 		<select id="newJudgeExam.examCatalog" name="newJudgeExam.examCatalog" class="required" >
							                 			<option value="1">科目一</option>
							                 			<option value="4">科目四</option>
							                 		</select>
							                 		
							                 	</td>
						               		</tr>
							               	
							               	
											
											<tr>
												<td class="table_rleft">试题答案：</td>
												<td>
													<input type="text" id="newJudgeExam.examAnswer"
													name="newJudgeExam.examAnswer" class="input_normal"
													/>
													<label><font color="red">(回答yes或者no)</font></label>
												</td>
												
											</tr>
											
									</table>
	                          	</td>
	                      	</tr>
	                    </table>
					</div>
					<div class="right_table_list">
		            	<table border="0" cellpadding="0" cellspacing="0" class="table_foot">
							<tr>
								<td>
							    	<input type="submit" class="button" value="保存"/>
		                            <input type="reset" class="button" value="重置"/>
		                            <input type="button" class="button" onclick="javascript:window.history.go(-1)" value="返回"/>
							    </td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
