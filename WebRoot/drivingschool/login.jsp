<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">

  <head>
    <base href="<%=basePath%>">
   <%--  <link href="<%=basePath%>css/login.css" type="text/css" rel="stylesheet"> --%>
    <title>驾校一点通</title>

    <meta name="viewport" content="width=1000, initial-scale=1.0, maximum-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="<%=basePath%>css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="<%=basePath%>css/bootstrap/flat-ui.css" rel="stylesheet">
   

    <link rel="shortcut icon" href="images/favicon.ico">
   
   <script language="JavaScript" type="text/javascript">
   		 $(document).ready(function() {
		    	document.getElementById("login-name").focus();
		    	$("#mylogin").validate({
		    		submitHandler: function() { 
		    			form.submit();
		    		},
		    		rules: {
		    			username: {
		    				required: true
		    			},
		    			userpassword: {
		    				required: true
		    			},
		    			rand:{
		    				required: true
		    			}
		    		}
		    	});
		    });
   
   
			if(top.frames.length!=0) top.location=self.document.location;
			function inrandRefresh(obj){
	    		if(obj.name=="image1"){
	    			obj.name="image2";
	    			obj.src="<%=basePath%>login/login!image.action";
	    		}else if(obj.name=="image2"){
					obj.name="image1";
	    			obj.src="<%=basePath%>system/login/image.jsp";   		
	    		}
	    	}

			function clears(){
				document.getElementById("indexusername").value="";
				document.getElementById("indexuserpassword").value="";
			}
		</script>
   
  </head>
  
  <body>

  	<div class="top">
	    <div class="minimenu">
	        <a onclick="" href="javascript:void(0)" target="_self">设为首页</a>|
	        <a onclick="" href="javascript:void(0)" target="_self">加入收藏</a>|
	        <a href="<%=basePath%>drivingschool/regedit.jsp">我要注册</a>               
	    </div>
	</div>
	
	<div class="login">
        <div class="login-screen">
          <div class="login-icon">
            <img src="<%=basePath%>images/loginpage/icon.png" alt="Welcome to driving examination!" />
            <h4>Welcome to <small>Driving Examination!</small></h4>
          </div>
	
          <div class="login-form">
          		<form id="mylogin" name="loginform" action="<%=basePath%>login/login!userLogin.action" method="post">
		           
		            <div class="form-group">
		              <input type="text" class="form-control login-field"  name="username" value="" placeholder="Enter your name" id="login-name" />
		              <label class="login-field-icon fui-user" for="login-name"></label>
		            </div>
		
		            <div class="form-group">
		              <input type="password" class="form-control login-field" name="userpassword" value="" placeholder="Password" id="login-pass" />
		              <label class="login-field-icon fui-lock" for="login-pass"></label>
		            </div>
					
					<div class="form-group">
						<label ><font color="#2ECC71" size="6">验证码:</font></label>
        				<input id="rand" type=text name="rand"  style="width:110px;color:#EC7063;" class="logo_input" />
	   					
	   					<span id="inrandSpan" style="vertical-align:middle;">
	            			<img id="image" name="image1" src="<%=basePath%>drivingschool/image.jsp" onclick="inrandRefresh(this);" style="cursor:hand; width:50px;height:15px" alt="看不清，换一张图片"/>
	        			 </span>
           			</div>
           			<button type="submit" class="btn btn-primary btn-lg btn-block">Log in</button>
<!-- 		            <a type="submit" class="btn btn-primary btn-lg btn-block" href="#">Log in</a> -->
		            <a class="login-link" href="#">Lost your password?</a>
		            <a class="login-link"  href="<%=basePath%>drivingschool/regedit.jsp">
						<img alt="用户注册" src="<%=basePath%>images/loginpage/regedit.gif">
					</a>
		        </form>
          </div>
        </div>
      </div>
	
	
	
	
  <%-- <div align="center">
	  	<table>
	  		<tr>
	  			<td><img style=width:100% src="<%=basePath%>images/loginpage/car.png"></td>
	  			<td>
	  				<div align="center"  style="padding: 10px"><font size="20px" >用户登录</font></div>
	  				<s:actionerror /> 
					<form id="mylogin" name="loginform" action="<%=basePath%>login/login!userLogin.action" method="post">
						<div align="center" style="padding: 5px">
							<label>用户名：</label>
							
							<input name="username" id="indexusername" maxlength="50"  >
	           				<label id="lblname"></label>
           				</div>
           				<div align="center" style="padding: 5px">
           					<label>密码：</label>
	           				<input type="password" id="indexuserpassword" name="userpassword">
	           				<label id="lblpwd"></label>
           				</div>
           				<div align="center" style="padding: 5px">
           					<label>验证码：</label>
           					<input id="rand" type=text name="rand"  style="width:110px;" class="logo_input"/>
			   					<span id="inrandSpan" style="vertical-align:middle;">
			            			<img id="image" name="image1" src="<%=basePath%>drivingschool/image.jsp" onclick="inrandRefresh(this);" style="cursor:hand; width:50px;height:15px" alt="看不清，换一张图片"/>
			        			 </span>
           				</div>
						<div style="padding: 5px">
							<div align="center">
								<button type="submit">
									<img alt="用户登录" src="<%=basePath%>images/loginpage/login.gif">
								</button>
								<a href="<%=basePath%>drivingschool/regedit.jsp">
									<img alt="用户注册" src="<%=basePath%>images/loginpage/regedit.gif">
								</a>
							</div>
						
						</div>
				    </form>	
			    </td>
	  		</tr>
	  		
		</table>
	</div> --%>
	
	
  </body>
</html>
