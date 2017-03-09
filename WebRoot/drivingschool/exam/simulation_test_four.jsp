<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=gb2312" /> -->
	<title>驾校在线科目四模拟考试</title>
	<link rel="stylesheet" href="<%=basePath%>css/index.css" type="text/css" />
	<style type="text/css">
	/*´òÓ¡Ê±£¬±³¾°Îª°×É«*/
		@media print{
			body{
			font-size:12px;
			background-color:#fff;
			}
			
			.div_topic{
			padding:5px;
			border:#000 dashed;
			border-width: 0 0 1px 0;
			background-color:#fff;
			}
			
			.div_topic h4{
			font-size:14px;
			color:#000;
			}
			
			.div_topic h4 span{ display:none}
			
			#answer_last {
			background-color:#eee;
			border:1px dashed #333;
			color:#000000;
			display:block;
			position: static;
			width:auto;
			height:auto;
			}
		
		
		}
	
	</style>
	<script src="js/jquery-1.11.3.js" type="text/javascript"></script>
	
	<script src="js/function1.js" type="text/javascript"></script>
		
<script>


$(document).ready(function(){

	
	$.post("<%=basePath%>beginexam/beginexam!abtainFourJsonData.action", function(data) {
		var arr_topic = eval(data);
		console.log("data:"+data);
		
		/* var arr_topic_length = 0;
		for(var arr in arr_topic){
			arr_topic_length++;
		} */
		console.log("dataarr_topic_length:"+arr_topic.length);
		$("#topic_all_num").html(arr_topic.length);

		$("#get_topic").click(function(){
			$("#status").html("");
			if($("#topic_all").html() != ""){
				if(!confirm("是否要重新出题？")){
					return;
				}else{
					$("#topic_all").html("");
				}
			}
			
			var topic_num = $("#topic_num").val();
			
			if(isNaN(topic_num)){
				$("#topic_num").val("100");
			}else{
				if(topic_num <= 0){
					$("#topic_num").val("100");
				}
				
				if(topic_num > arr_topic.length){
					$("#topic_num").val(arr_topic.length);
				}
			}
			
					
			
			topic_num = $("#topic_num").val();
			
			get_topic(arr_topic,topic_num);
			int();
	
		});
		 console.log("arr_topic:"+arr_topic);
	});
	
	/* function saveScore(score){
		console.log("begin+lhgdialog"+score);
		$.ajax({
			url:"report/report!reportfourSave.action",
			dataType:"text",	
			data:{score:score},
			async:false,
			success:(function(data){
				alert(data);
			})
		});
		
	} */
});

</script>
	
	
</head>
<body>
<div id="fixedLayer"><div>
	<p>
		<span id="topic_right">
			<%-- <form action="<%=basePath%>report/report!reportSave.action" method="post" name="myForm">
				<input type="hidden" id="score" name="score" value="" />
				<input type="button" value="保存" />
			</form> --%>
			<input name="show_answer" id="show_answer" type="button" value=" 答案 " onclick='$("#answer_last").toggle();'/>
			<input name="check_answer" id="check_answer" type="button" value=" 算分"/>
			<%-- <a href="<%=basePath%>report/report!reportSave.action?score=" target="_self"></a> --%>
		</span>
		您的题库一共有
		<span id="topic_all_num">
		</span>
		道题，您要做其中
		<input name="topic_num" type="text" id="topic_num" value="100" />
		道
		<input name="get_topic" id="get_topic" type="button" value=" 出题 "/> 
		<span id="status">
		</span>
	</p>
	
</div>
</div>
<br/>
<br/>
<br/>
<div id="topic_all"></div>
<div id="answer_last"></div>
</body>
</html>