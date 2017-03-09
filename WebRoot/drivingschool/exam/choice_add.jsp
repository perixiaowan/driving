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
    <script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
    
    <script src="<%=basePath%>js/table_show.js"  type="text/javascript" ></script>
    <script type="text/javascript">
	    $(document).ready(function() {
	    	$("#myFrm").validate({
	    		submitHandler: function() { 
	    			form.submit();
	    		},
	    		rules: {
	    			"newChoiceExam.examTitle": {
	    				required: true,
	    				minlength: 2,
	    				maxlength: 100
	    			},
	    			"newChoiceExam.examAnswer": {
	    				required: true,
	    				minlength: 2,
	    				maxlength: 2
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
	       		<form action="<%=basePath%>exam/exam!choiceSave.action" name="myform" id="myFrm" method="post">
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
							                 		<textarea id="newChoiceExam.examTitle" name="newChoiceExam.examTitle" rows="2" cols="50"></textarea>
							                 		<img src="<%=basePath%>images/title/xinghao_03.jpg" />
					                         		<%-- <input type="text" id="newTitle.examTitle" name="newTitle.examTitle" class="input_normal" />
					                         		<img src="<%=basePath%>images/title/xinghao_03.jpg" /> --%>
							                 	</td>
							               	</tr>
							               		<tr>
							                 	<td class="table_rleft">
							                 		科目类型：
							                 	</td>
							                 	<td>
							                 		<select id="newChoiceExam.examCatalog" name="newChoiceExam.examCatalog" class="required" >
							                 			<option value="1">科目一</option>
							                 			<option value="4">科目四</option>
							                 			
							                 		</select>
							                 		
							                 	</td>
						               		</tr>
							               	
							               	
											<tr>
												<td class="table_rleft">选项一：</td>
												<td>
												<textarea id="newChoiceExam.examOption1" name="newChoiceExam.examOption1" rows="2" cols="50"></textarea>
												</td>
											
											</tr>
											<tr>
												<td class="table_rleft">选项二：</td>
												<td>
												<textarea id="newChoiceExam.examOption2" name="newChoiceExam.examOption2" rows="2" cols="50"></textarea>
												</td>
											
											</tr>
											<tr>
												<td class="table_rleft">选项三：</td>
												<td>
												<textarea id="newChoiceExam.examOption3" name="newChoiceExam.examOption3" rows="2" cols="50"></textarea>
												</td>
											
											</tr>
											<tr>
												<td class="table_rleft">选项四：</td>
												<td>
												<textarea id="newChoiceExam.examOption4" name="newChoiceExam.examOption4" rows="2" cols="50"></textarea>
												</td>
											
											</tr>
											<tr>
												<td class="table_rleft" width="20%">试题答案：</td>
												<td><input type="text" id="newTitle.examAnswer"
													name="newChoiceExam.examAnswer" class="input_normal"
													/></td>
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
