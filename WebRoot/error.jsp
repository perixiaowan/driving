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
    
    <title>新闻抓取失败！</title>
   	<style type="text/css">
		* { margin:0; padding:0; }
		a { text-decoration:none; }
		ul { list-style:none; }
		img { border:none; }
		body { font-family:Verdana, Geneva, sans-serif; font-size:12px; text-align:center; }
		.clear { clear:both; }
		.wjx_kcxer{ margin:10px; float:left;  height:50px; width:100%}
		.wjx_kcxer img{ float: left;}
		.wjx_kcxer p{font-size:14px; font-weight:bold; text-indent:64px; text-align:left; line-height:50px;}
	</style>
	<script type="text/javascript">
		function endTime(i){
			var str = "";
			for(var j=0;j<i;j++){
				str = str + ".";
			}
			document.getElementById('txt').innerHTML="新闻抓取失败！可能是网络连接出故障"+str;
			i++;
			if(i<=6){
				t=setTimeout('endTime('+i+')',1000);
			}else{
				i = 0;
				t=setTimeout('endTime('+i+')',1000);
			}
		}
	</script>
  </head>
  
  <body onload="endTime(0)">
   	<div class="wjx">
		<div class="wjx_kcxer"> <img src="<%=basePath%>images/err.jpg" />
			<h3 align="right"><a href="<%=basePath%>" >返回首页</a></h3>
			<p id="txt" style="text-indent:15px;"></p>
			<p>请稍后重试！</p>
			

			
			
			
		</div>
	</div>
  </body>
</html>
